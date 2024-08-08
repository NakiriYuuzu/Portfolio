package core.domain.repository

import core.domain.model.DarkThemePreference

interface SettingRepository {
    suspend fun getThemePreference(): DarkThemePreference
    suspend fun setThemePreference(isDarkTheme: Int)
    suspend fun getThemeColor(): Long
    suspend fun setThemeColor(color: String)
}