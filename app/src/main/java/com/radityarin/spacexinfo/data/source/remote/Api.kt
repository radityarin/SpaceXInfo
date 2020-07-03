package com.radityarin.spacexinfo.data.source.remote

import com.radityarin.spacexinfo.data.model.historical.History
import com.radityarin.spacexinfo.data.model.launches.Launch
import com.radityarin.spacexinfo.data.model.rockets.Rockets
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface Api {

    @GET("launches")
    fun getAllLaunch(): Observable<ArrayList<Launch>>

    @GET("launches/upcoming")
    fun getUpcomingLaunch(): Observable<ArrayList<Launch>>

    @GET("launches/past")
    fun getPastLaunch(): Observable<ArrayList<Launch>>

    @GET("launches/latest")
    fun getLatestLaunch(): Observable<Launch>

    @GET("history")
    fun getHistoricalEvents(): Observable<ArrayList<History>>

    @GET("rockets")
    fun getAllRockets(): Observable<ArrayList<Rockets>>

}