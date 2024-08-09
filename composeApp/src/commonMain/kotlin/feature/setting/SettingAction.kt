package feature.setting

sealed interface SettingAction {
    data object OnBackClicked: SettingAction
    data class OnThemeColorChanged(val color: Long): SettingAction
    data class OnThemePreferenceChanged(val mode: Int): SettingAction
}