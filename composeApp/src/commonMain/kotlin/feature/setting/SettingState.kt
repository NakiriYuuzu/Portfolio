package feature.setting

import androidx.compose.ui.graphics.Color
import core.presentation.theme.seed
import core.domain.model.DarkThemePreference

data class SettingState(
    val seedColor: Color = seed,
    val darkTheme: DarkThemePreference = DarkThemePreference()
)