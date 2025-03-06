package feature.setting

import androidx.compose.foundation.text.input.TextFieldState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import core.domain.model.DarkThemePreference
import core.domain.repository.SettingRepository
import core.util.extension.toColor
import core.util.extension.toLongColor
import core.util.extension.toStringColor
import feature.setting.validator.SettingValidator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SettingViewModel(
    private val settingValidator: SettingValidator,
    private val settingRepository: SettingRepository
) : ViewModel() {
    private val _state = MutableStateFlow(SettingState())
    val state = _state
        .onStart { execute() }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), SettingState())

    fun onAction(action: SettingAction) {
        when (action) {
            is SettingAction.OnThemeColorChanged -> onThemeColorChanged(action.colorText)
            is SettingAction.OnThemePreferenceChanged -> onThemePreferenceChanged(action.mode)
            else -> Unit
        }
    }

    private fun execute() {
        viewModelScope.launch {
            val themeColor = settingRepository.getThemeColor()
            val themePreference = settingRepository.getThemePreference()
            val colorString = themeColor.toStringColor()
            val validatorState = settingValidator.validateColor(colorString)

            _state.value = _state.value.copy(
                seedColor = themeColor.toColor(),
                darkTheme = themePreference,
                validatorState = validatorState,
                colorField = TextFieldState(colorString)
            )
        }
    }

    private fun onThemeColorChanged(colorText: String) {
        // 驗證顏色
        val validatorState = settingValidator.validateColor(colorText)

        // 更新輸入框狀態
        _state.value = _state.value.copy(
            validatorState = validatorState,
            colorField = TextFieldState(colorText)
        )

        // 如果顏色有效，則更新儲存庫
        if (validatorState.isColor) {
            viewModelScope.launch {
                try {
                    // 將十六進制字符串轉換為 Long (添加 alpha 通道前綴 FF)
                    val colorLong = colorText.toLongColor()
                    settingRepository.setThemeColor(colorLong)
                    _state.value = _state.value.copy(seedColor = colorLong.toColor())
                } catch (e: Exception) {
                    // 錯誤處理 - 在實際應用中，可能需要顯示錯誤訊息
                }
            }
        }
    }

    private fun onThemePreferenceChanged(isDarkTheme: Int) {
        viewModelScope.launch {
            settingRepository.setThemePreference(isDarkTheme)
            _state.value = _state.value.copy(darkTheme = DarkThemePreference(isDarkTheme))
        }
    }
}