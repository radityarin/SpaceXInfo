package com.radityarin.spacexinfo.widget

import androidx.lifecycle.ViewModel
import com.radityarin.spacexinfo.data.repository.AppRepository

data class NextLaunchWidgetViewModel(
    private val repository: AppRepository
) : ViewModel()