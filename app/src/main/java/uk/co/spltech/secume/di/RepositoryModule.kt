package uk.co.spltech.secume.di

import org.koin.dsl.module.module
import uk.co.spltech.secume.ui.home.fragment.HomeRepository

val repositoryModule = module {
    single {
        HomeRepository(
            apiService = get(),
            schedulerProvider = get()
        )
    }
}