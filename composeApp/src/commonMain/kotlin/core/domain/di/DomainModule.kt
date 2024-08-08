package core.domain.di

import core.data.source.PortfolioLocalSourceImpl
import core.domain.source.PortfolioSource
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal val domainModule = module {
    factoryOf(::PortfolioLocalSourceImpl).bind(PortfolioSource.Local::class)
}