import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import di.appModules
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.logger.PrintLogger

fun main() {
    startKoin {
        logger(PrintLogger(level = Level.DEBUG))
        modules(appModules)
    }

    return application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Portfolio",
        ) {
            App()
        }
    }
}