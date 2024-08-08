package core.domain.source

import core.domain.model.DarkThemePreference

interface PortfolioSource {
    interface Remote {

    }

    // NON DATABASE
    interface Local {
        suspend fun getThemePreference(): DarkThemePreference
        suspend fun setThemePreference(isDarkTheme: Int)
        suspend fun getThemeColor(): Long
        suspend fun setThemeColor(color: String)
    }
}