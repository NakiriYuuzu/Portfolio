package core.logging.di

import core.logging.KermitLogger
import core.logging.Logger
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val loggingModule = module {
    singleOf<Logger>(::KermitLogger)
}