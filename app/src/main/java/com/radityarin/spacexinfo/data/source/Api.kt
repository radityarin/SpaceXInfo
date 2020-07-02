package com.radityarin.spacexinfo.data.source

import com.radityarin.spacexinfo.data.model.historical.History
import com.radityarin.spacexinfo.data.model.launches.Launches
import com.radityarin.spacexinfo.data.model.launches.LaunchesItem
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

@JvmSuppressWildcards
interface Api {

    @GET("launches")
    fun getAllLaunch(): Observable<Launches>

    @GET("launches/upcoming")
    fun getUpcomingLaunch(): Observable<Launches>

    @GET("launches/past")
    fun getPastLaunch(): Observable<Launches>

    @GET("launches/latest")
    fun getLatestLaunch(): Observable<LaunchesItem>

    @GET("history")
    fun getHistoricalEvents(): Observable<History>
}