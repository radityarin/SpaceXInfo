package com.radityarin.spacexinfo.di

import com.radityarin.spacexinfo.ui.history.HistoryFragmentViewModel
import com.radityarin.spacexinfo.ui.missions.MissionsFragmentViewModel
import com.radityarin.spacexinfo.ui.settings.SettingsFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MissionsFragmentViewModel(get()) }
    viewModel { HistoryFragmentViewModel(get()) }
    viewModel { SettingsFragmentViewModel(get()) }
}