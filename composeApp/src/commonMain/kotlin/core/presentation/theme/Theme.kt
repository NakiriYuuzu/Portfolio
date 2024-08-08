package core.presentation.theme

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.materialkolor.DynamicMaterialTheme
import core.util.LocalDynamicThemeState

@Composable
internal fun Theme(
    content: @Composable () -> Unit
) {
    val themeState = LocalDynamicThemeState.current

    DynamicMaterialTheme(
        state = themeState,
        animate = true,
        typography = SoraTypography(),
        shapes = yuuzuShape,
        content = {
            Surface(content = content)
        }
    )
}