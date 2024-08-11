package feature.di

import feature.setting.SettingViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

internal val viewModelModule = module {
    singleOf(::SettingViewModel)
}