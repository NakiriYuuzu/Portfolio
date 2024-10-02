package feature

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.materialkolor.PaletteStyle
import com.materialkolor.rememberDynamicMaterialThemeState
import core.util.LocalDarkTheme
import core.util.LocalDynamicThemeState
import core.util.LocalScreenSize
import core.util.LocalSeedColor
import core.util.ScreenSize
import core.util.getScreenHeightDp
import core.util.getScreenWidthDp
import feature.setting.SettingState

@Composable
fun AppSettingProvider(
    state: SettingState,
    content: @Composable () -> Unit
) {
    state.run {
        val themeState = rememberDynamicMaterialThemeState(
            seedColor = seedColor,
            isDark = darkTheme.isDarkTheme(),
            style = PaletteStyle.Content
        )

        CompositionLocalProvider(
            LocalDarkTheme provides state.darkTheme,
            LocalSeedColor provides state.seedColor,
            LocalDynamicThemeState provides themeState,
            LocalScreenSize provides ScreenSize(width = getScreenWidthDp(), height = getScreenHeightDp())
        ) {
            content()
        }
    }
}