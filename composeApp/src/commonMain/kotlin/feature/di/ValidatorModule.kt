package feature.di

import feature.setting.validator.SettingValidator
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val validatorModule = module {
    factoryOf(::SettingValidator)
}