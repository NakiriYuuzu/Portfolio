package core.domain.model

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.stringResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.theme_dark_off
import portfolio.composeapp.generated.resources.theme_dark_on
import portfolio.composeapp.generated.resources.theme_follow_system

data class DarkThemePreference(
    val darkThemeValue: Int = DarkTheme.FOLLOW_SYSTEM.value
) {
    enum class DarkTheme(val value: Int) {
        FOLLOW_SYSTEM(1),
        ON(2),
        OFF(3)
    }

    @Composable
    fun isDarkTheme(): Boolean {
        return when (darkThemeValue) {
            DarkTheme.FOLLOW_SYSTEM.value -> isSystemInDarkTheme()
            DarkTheme.ON.value -> true
            else -> false
        }
    }

    @Composable
    fun getDarkThemeDesc(): String {
        return when (darkThemeValue) {
            DarkTheme.FOLLOW_SYSTEM.value -> stringResource(Res.string.theme_follow_system)
            DarkTheme.ON.value -> stringResource(Res.string.theme_dark_on)
            DarkTheme.OFF.value -> stringResource(Res.string.theme_dark_off)
            else -> throw IllegalArgumentException("Invalid dark theme value")
        }
    }
}
