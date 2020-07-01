package com.radityarin.spacexinfo.data.source

import com.radityarin.spacexinfo.data.model.launches.Launches
import com.radityarin.spacexinfo.data.model.launches.LaunchesItem
import io.reactivex.Observable
import retrofit2.http.GET

@JvmSuppressWildcards
interface Api {

    @GET("launches")
    fun getAllLaunches(): Observable<Launches>

    @GET("launches/upcoming")
    fun getUpcomingLaunches(): Observable<Launches>

    @GET("launches/latest")
    fun getLatestLaunches(): Observable<LaunchesItem>

}