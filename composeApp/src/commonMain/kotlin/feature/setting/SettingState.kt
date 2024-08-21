package feature.setting

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import core.presentation.theme.seed
import core.domain.model.DarkThemePreference
import core.util.extension.toStringColor
import feature.setting.validator.SettingValidatorState

data class SettingState(
    val seedColor: Color = seed,
    val darkTheme: DarkThemePreference = DarkThemePreference(),
    val validatorState: SettingValidatorState = SettingValidatorState(),
    val colorField: TextFieldState = TextFieldState(seedColor.toStringColor())
)