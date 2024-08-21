package di

import core.data.di.dataModule
import core.domain.di.domainModule
import core.logging.di.loggingModule
import core.util.di.utilityModule
import feature.di.validatorModule
import feature.di.viewModelModule

internal val appModules = listOf(
    // Add your modules here
    utilityModule,
    loggingModule,
    dataModule,
    domainModule,
    validatorModule,
    viewModelModule
)