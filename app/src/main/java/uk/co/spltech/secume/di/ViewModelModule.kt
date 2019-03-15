package uk.co.spltech.secume.di

import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import uk.co.spltech.secume.ui.home.fragment.HomeViewModel

val viewModelModule = module {
    viewModel { HomeViewModel(homeRepository = get()) }
}