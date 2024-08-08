package core.domain.source

import core.presentation.theme.ThemeMode

interface PortfolioSource {
    interface Remote {

    }

    // NON DATABASE
    interface Local {
        suspend fun getErrorMessage(): String
        suspend fun setErrorMessage(message: String)
        suspend fun getThemeMode(): ThemeMode
        suspend fun setThemeMode(theme: ThemeMode)
        suspend fun getThemeColor(): Long
        suspend fun setThemeColor(color: String)
    }
}