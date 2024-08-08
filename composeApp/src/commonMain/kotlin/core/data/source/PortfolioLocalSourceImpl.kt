package core.data.source

import com.russhwolf.settings.Settings
import com.russhwolf.settings.set
import core.domain.source.PortfolioSource
import core.presentation.theme.ThemeMode
import core.util.DispatcherProvider
import kotlinx.coroutines.withContext

class PortfolioLocalSourceImpl(
    private val settings: Settings,
    private val dispatcherProvider: DispatcherProvider
) : PortfolioSource.Local {

    override suspend fun getErrorMessage(): String =
        withContext(dispatcherProvider.io) {
            settings.getString(ERROR_MESSAGE_KEY, "")
        }

    override suspend fun setErrorMessage(message: String) =
        withContext(dispatcherProvider.io) {
            settings[ERROR_MESSAGE_KEY] = message
        }

    override suspend fun getThemeMode(): ThemeMode =
        withContext(dispatcherProvider.io) {
            settings.getString(DARK_MODE_KEY, ThemeMode.SYSTEM.name).let {
                return@let ThemeMode.valueOf(it)
            }
        }

    override suspend fun setThemeMode(theme: ThemeMode) =
        withContext(dispatcherProvider.io) {
            settings[DARK_MODE_KEY] = theme.name
        }

    override suspend fun getThemeColor(): Long =
        withContext(dispatcherProvider.io) {
            settings.getLong(THEME_COLOR_THEME_KEY, 0)
        }

    override suspend fun setThemeColor(color: String) =
        withContext(dispatcherProvider.io) {
            settings[THEME_COLOR_THEME_KEY] = color.toLong()
        }

    companion object {
        private const val DARK_MODE_KEY = "DARK_MODE_KEY"
        private const val ERROR_MESSAGE_KEY = "ERROR_MESSAGE_KEY"
        private const val THEME_COLOR_THEME_KEY = "THEME_COLOR_THEME_KEY"
    }
}