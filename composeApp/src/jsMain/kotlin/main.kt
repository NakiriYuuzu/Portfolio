import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import di.appModules
import org.jetbrains.skiko.wasm.onWasmReady
import org.koin.core.context.startKoin
import org.koin.core.logger.PrintLogger
import org.koin.core.logger.Level.DEBUG

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    startKoin {
        logger(PrintLogger(level = DEBUG))
        modules(appModules)
    }
    onWasmReady {
        CanvasBasedWindow(canvasElementId = "ComposeTarget") { App() }
    }
}