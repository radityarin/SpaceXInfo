package com.radityarin.spacexinfo.di

import com.radityarin.spacexinfo.ui.about.AboutActivityViewModel
import com.radityarin.spacexinfo.ui.history.HistoryFragmentViewModel
import com.radityarin.spacexinfo.ui.missions.MissionsFragmentViewModel
import com.radityarin.spacexinfo.ui.rockets.RocketFragmentViewModel
import com.radityarin.spacexinfo.widget.NextLaunchWidgetViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MissionsFragmentViewModel(get()) }
    viewModel { RocketFragmentViewModel(get()) }
    viewModel { HistoryFragmentViewModel(get()) }
    viewModel { NextLaunchWidgetViewModel(get()) }
    viewModel { AboutActivityViewModel(get()) }
}