package feature.setting

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import core.domain.model.DarkThemePreference
import core.domain.repository.SettingRepository
import core.util.extension.toColor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SettingViewModel(
    private val settingRepository: SettingRepository
) : ViewModel() {
    private val _state = MutableStateFlow(SettingState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val themeColor = settingRepository.getThemeColor()
            val themePreference = settingRepository.getThemePreference()

            _state.value = _state.value.copy(
                seedColor = themeColor.toColor(),
                darkTheme = themePreference
            )
        }
    }

    fun onThemeColorChanged(color: Long) {
        viewModelScope.launch {
            settingRepository.setThemeColor(color)
            _state.value = _state.value.copy(seedColor = Color(color))
        }
    }

    fun onThemePreferenceChanged(isDarkTheme: Int) {
        viewModelScope.launch {
            settingRepository.setThemePreference(isDarkTheme)
            _state.value = _state.value.copy(darkTheme = DarkThemePreference(isDarkTheme))
        }
    }
}