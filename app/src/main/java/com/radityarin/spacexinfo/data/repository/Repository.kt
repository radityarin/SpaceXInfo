package com.radityarin.spacexinfo.data.repository

import com.radityarin.spacexinfo.data.model.launches.Launches
import com.radityarin.spacexinfo.data.model.launches.LaunchesItem
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.internal.disposables.ArrayCompositeDisposable

interface Repository {

    fun getAllLaunches(
        compositeDisposable: CompositeDisposable,
        onResult: (Launches) -> Unit
    )

    fun getUpcomingLaunches(
        compositeDisposable: CompositeDisposable,
        onResult: (Launches) -> Unit
    )

    fun getLatestLaunches(
        compositeDisposable: CompositeDisposable,
        onResult: (LaunchesItem) -> Unit
    )
}