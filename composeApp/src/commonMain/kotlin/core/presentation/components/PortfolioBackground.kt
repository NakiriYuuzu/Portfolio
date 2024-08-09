package core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import core.util.getScreenHeightDp
import core.util.getScreenWidthDp

@Composable
fun PortfolioBackground(
    hasToolbar: Boolean = true,
    modifier: Modifier = Modifier,
    primaryColor: Color = MaterialTheme.colorScheme.primary,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    primaryAlpha: Float = 0.3f,
    enableShadow: Boolean = false,
    content: @Composable ColumnScope.() -> Unit
) {
    val density = LocalDensity.current

    val screenWidthPx = with(density) {
        getScreenWidthDp().roundToPx()
    }
    val smallDimension = minOf(
        getScreenWidthDp(),
        getScreenHeightDp()
    )
    val smallDimensionPx = with(density) {
        smallDimension.roundToPx()
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            primaryColor.copy(alpha = primaryAlpha),
                            backgroundColor
                        ),
                        center = Offset(
                            x = screenWidthPx / 2f,
                            y = screenWidthPx / 4f
                        ),
                        radius = smallDimensionPx / 1.5f
                    )
                )
                .then(if (enableShadow) Modifier.shadow(8.dp) else Modifier)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .then(if (hasToolbar) Modifier else Modifier.systemBarsPadding())
        ) {
            content()
        }
    }
}