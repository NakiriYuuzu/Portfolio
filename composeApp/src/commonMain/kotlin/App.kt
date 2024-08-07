import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.materialkolor.PaletteStyle
import com.materialkolor.rememberDynamicMaterialThemeState
import core.presentation.theme.Theme
import core.presentation.theme.seed
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
internal fun App() {
    KoinContext {
        var isDarkTheme by rememberSaveable { mutableStateOf(false) }
        var seedColor by rememberSaveable { mutableStateOf(seed) }
        val state = rememberDynamicMaterialThemeState(
            seedColor = seedColor,
            isDark = isDarkTheme,
            style = PaletteStyle.Content
        )

        Theme(state = state) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "Hello, World!", style = MaterialTheme.typography.displayLarge)
                Button(onClick = {
                    seedColor = Color((0..0xFFFFFF).random())
                    isDarkTheme = !isDarkTheme
                }) {
                    Text(text = "Click me!")
                }
            }
        }
    }
}