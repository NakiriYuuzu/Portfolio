package core.util.di

import core.util.getDispatcherProvider
import org.koin.dsl.module

internal val utilityModule = module {
    factory { getDispatcherProvider() }
}