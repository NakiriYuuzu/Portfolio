import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.materialkolor.PaletteStyle
import com.materialkolor.rememberDynamicMaterialThemeState
import core.domain.source.PortfolioSource
import core.presentation.theme.Theme
import core.presentation.theme.seed
import core.util.LocalWindowSizeClass
import core.util.extension.toColor
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.getKoin

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
@Preview
internal fun App() {
    KoinContext {
        val local: PortfolioSource.Local = getKoin().get()

        CompositionLocalProvider(
            LocalWindowSizeClass provides calculateWindowSizeClass()
        ) {

            val coroutineScope = rememberCoroutineScope()
            var seedColor by rememberSaveable { mutableStateOf(seed) }
            val state = rememberDynamicMaterialThemeState(
                seedColor = seedColor,
                isDark = isSystemInDarkTheme(),
                style = PaletteStyle.Content
            )

            LaunchedEffect(seedColor) {
                seedColor = local.getThemeColor().toColor()
            }

            Theme(state = state) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = "Current Platform: wasmJS!", style = MaterialTheme.typography.displayLarge)
                    Button(onClick = {
                        val randomColor = (0..0xFFFFFF).random()
                        seedColor = Color(randomColor)
                        coroutineScope.launch {
                            local.setThemeColor(randomColor.toString())
                        }
                    }) {
                        Text(text = "Click Me!")
                    }
                }
            }
        }
    }
}