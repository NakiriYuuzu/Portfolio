package core.util

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp

internal val LocalWindowSizeClass =
    staticCompositionLocalOf<WindowSizeClass> { error("No WindowSizeClass found") }

@Composable
internal expect fun getScreenWidthDp(): Dp

@Composable
internal expect fun getScreenHeightDp(): Dp