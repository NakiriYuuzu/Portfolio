package core.data.di

import com.russhwolf.settings.Settings
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal val dataModule = module {
    factoryOf<Settings>(::Settings)
}