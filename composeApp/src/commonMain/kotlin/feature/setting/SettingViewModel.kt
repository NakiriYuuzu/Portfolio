package feature.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
}