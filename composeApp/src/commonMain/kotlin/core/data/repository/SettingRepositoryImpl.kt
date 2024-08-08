package core.data.repository

import core.domain.repository.SettingRepository
import core.domain.source.PortfolioSource
import core.domain.model.DarkThemePreference

class SettingRepositoryImpl(
    private val localSource: PortfolioSource.Local
) : SettingRepository {
    override suspend fun getThemePreference(): DarkThemePreference = localSource.getThemePreference()

    override suspend fun setThemePreference(isDarkTheme: Int) = localSource.setThemePreference(isDarkTheme)

    override suspend fun getThemeColor(): Long = localSource.getThemeColor()

    override suspend fun setThemeColor(color: Long) = localSource.setThemeColor(color)
}