package feature.setting

sealed interface SettingAction {
    data object OnBackClicked: SettingAction
    data class OnThemeColorChanged(val colorText: String): SettingAction
    data class OnThemePreferenceChanged(val mode: Int): SettingAction
}