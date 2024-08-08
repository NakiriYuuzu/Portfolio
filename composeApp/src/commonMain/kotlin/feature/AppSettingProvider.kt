package feature

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.materialkolor.PaletteStyle
import com.materialkolor.rememberDynamicMaterialThemeState
import core.util.LocalDarkTheme
import core.util.LocalDynamicThemeState
import core.util.LocalSeedColor
import core.util.LocalWindowSizeClass
import feature.setting.SettingState

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
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
            LocalWindowSizeClass provides calculateWindowSizeClass()
        ) {
            content()
        }
    }
}