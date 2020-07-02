package com.radityarin.spacexinfo.di

import com.radityarin.spacexinfo.ui.missions.MissionsFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MissionsFragmentViewModel(get()) }
}