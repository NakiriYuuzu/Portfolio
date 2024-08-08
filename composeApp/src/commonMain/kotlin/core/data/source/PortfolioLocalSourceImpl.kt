package core.data.source

import com.russhwolf.settings.Settings
import com.russhwolf.settings.set
import core.domain.source.PortfolioSource
import core.util.DispatcherProvider
import core.domain.model.DarkThemePreference
import kotlinx.coroutines.withContext

class PortfolioLocalSourceImpl(
    private val settings: Settings,
    private val dispatcherProvider: DispatcherProvider
) : PortfolioSource.Local {
    override suspend fun getThemePreference(): DarkThemePreference =
        withContext(dispatcherProvider.io) {
            DarkThemePreference(
                settings.getInt(DARK_MODE_KEY, DarkThemePreference.FOLLOW_SYSTEM)
            )
        }

    override suspend fun setThemePreference(isDarkTheme: Int) =
        withContext(dispatcherProvider.io) {
            settings[DARK_MODE_KEY] = isDarkTheme
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
        private const val THEME_COLOR_THEME_KEY = "THEME_COLOR_THEME_KEY"
    }
}