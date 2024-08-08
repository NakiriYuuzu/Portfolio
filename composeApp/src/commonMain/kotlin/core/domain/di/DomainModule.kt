package core.domain.di

import core.data.repository.SettingRepositoryImpl
import core.data.source.PortfolioLocalSourceImpl
import core.domain.repository.SettingRepository
import core.domain.source.PortfolioSource
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal val domainModule = module {
    factoryOf(::PortfolioLocalSourceImpl).bind(PortfolioSource.Local::class)
    factoryOf(::SettingRepositoryImpl).bind(SettingRepository::class)
}