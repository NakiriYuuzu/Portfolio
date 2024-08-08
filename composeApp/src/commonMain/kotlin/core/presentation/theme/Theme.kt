package core.presentation.theme

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.materialkolor.DynamicMaterialTheme
import com.materialkolor.DynamicMaterialThemeState

@Composable
internal fun Theme(
    state: DynamicMaterialThemeState,
    content: @Composable () -> Unit
) {
    DynamicMaterialTheme(
        state = state,
        animate = true,
        typography = SoraTypography(),
        shapes = yuuzuShape,
        content = {
            Surface(content = content)
        }
    )
}