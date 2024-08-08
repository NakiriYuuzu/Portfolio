import androidx.compose.ui.window.ComposeUIViewController
import di.appModules
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.logger.PrintLogger

fun MainViewController() = ComposeUIViewController(
    configure = {
        startKoin {
            logger(PrintLogger(level = Level.DEBUG))
            modules(appModules)
        }
    }
) { App() }