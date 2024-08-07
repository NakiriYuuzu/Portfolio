import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import org.koin.core.context.startKoin
import org.koin.core.logger.PrintLogger
import org.koin.core.logger.Level.DEBUG

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    startKoin {
        logger(PrintLogger(level = DEBUG))
        modules()
    }
    return ComposeViewport(document.body!!) {
        App()
    }
}