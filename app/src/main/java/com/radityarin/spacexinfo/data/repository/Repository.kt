package com.radityarin.spacexinfo.data.repository

import com.radityarin.spacexinfo.data.model.historical.History
import com.radityarin.spacexinfo.data.model.launches.Launch
import com.radityarin.spacexinfo.data.model.rockets.Rockets
import io.reactivex.rxjava3.core.Observable

interface Repository {

    fun getAllLaunch(): Observable<ArrayList<Launch>>
    fun getPastLaunch(): Observable<ArrayList<Launch>>
    fun getUpcomingLaunch(): Observable<ArrayList<Launch>>
    fun getLatestLaunch(): Observable<Launch>
    fun getNextLaunch(): Observable<Launch>
    fun getHistoricalEvents(): Observable<ArrayList<History>>
    fun getAllRockets(): Observable<ArrayList<Rockets>>
    fun getCacheAllLaunch(): ArrayList<Launch>?
    fun getCachePastLaunch(): ArrayList<Launch>?
    fun getCacheUpcomingLaunch(): ArrayList<Launch>?
    fun getCacheLatestLaunch(): Launch?
    fun getCacheNextLaunch(): Launch?
    fun getCacheHistoricalEvents(): ArrayList<History>?
    fun getCacheAllRockets(): ArrayList<Rockets>?

}