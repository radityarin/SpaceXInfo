package com.radityarin.spacexinfo.data.repository

import com.radityarin.spacexinfo.data.model.historical.History
import com.radityarin.spacexinfo.data.model.launches.Launches
import com.radityarin.spacexinfo.data.model.launches.LaunchesItem
import io.reactivex.disposables.CompositeDisposable

interface Repository {

    fun getAllLaunch(
        compositeDisposable: CompositeDisposable,
        onResult: (Launches) -> Unit
    )

    fun getPastLaunch(
        compositeDisposable: CompositeDisposable,
        onResult: (Launches) -> Unit
    )

    fun getUpcomingLaunch(
        compositeDisposable: CompositeDisposable,
        onResult: (Launches) -> Unit
    )

    fun getLatestLaunch(
        compositeDisposable: CompositeDisposable,
        onResult: (LaunchesItem) -> Unit
    )

    fun getHistoricalEvents(
        compositeDisposable: CompositeDisposable,
        onResult: (History) -> Unit
    )
}