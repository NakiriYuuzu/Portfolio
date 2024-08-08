package core.domain.model

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable

data class DarkThemePreference(
    val darkThemeValue: Int = FOLLOW_SYSTEM
) {
    companion object {
        const val FOLLOW_SYSTEM = 1
        const val ON = 2
        const val OFF = 3 // Non used
    }

    @Composable
    fun isDarkTheme(): Boolean {
        return if (darkThemeValue == FOLLOW_SYSTEM)
            isSystemInDarkTheme()
        else darkThemeValue == ON
    }

//    @Composable
//    fun getDarkThemeDesc(): String {
//        return when (darkThemeValue) {
//            FOLLOW_SYSTEM -> stringResource(Res.string.theme_follow_system)
//            ON -> stringResource(Res.string.theme_dark_on)
//            else -> stringResource(Res.string.theme_dark_off)
//        }
//    }
}
