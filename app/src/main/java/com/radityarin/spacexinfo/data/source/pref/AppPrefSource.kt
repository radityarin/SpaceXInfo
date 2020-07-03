package com.radityarin.spacexinfo.data.source.pref

import com.orhanobut.hawk.Hawk
import com.radityarin.spacexinfo.data.model.historical.History
import com.radityarin.spacexinfo.data.model.launches.Launch
import com.radityarin.spacexinfo.data.model.rockets.Rockets
import com.radityarin.spacexinfo.util.CacheKey

class AppPrefSource {

    fun getAllLaunch(): ArrayList<Launch>? = Hawk.get(CacheKey.ALL_LAUNCH, null)
    fun getUpcomingLaunch(): ArrayList<Launch>? = Hawk.get(CacheKey.UPCOMING_LAUNCH, null)
    fun getPastLaunch(): ArrayList<Launch>? = Hawk.get(CacheKey.PAST_LAUNCH, null)
    fun getLatestLaunch(): Launch? = Hawk.get(CacheKey.LATEST_LAUNCH, null)
    fun getHistoricalEvents(): ArrayList<History>? = Hawk.get(CacheKey.HISTORICAL_EVENTS, null)
    fun getAllRockets(): ArrayList<Rockets>? = Hawk.get(CacheKey.ALL_ROCKETS, null)

    fun setCacheAllLaunch(launches: ArrayList<Launch>) = Hawk.put(CacheKey.ALL_LAUNCH, launches)
    fun setCacheUpcomingLaunch(launches: ArrayList<Launch>)= Hawk.put(CacheKey.UPCOMING_LAUNCH, launches)
    fun setCachePastLaunch(launches: ArrayList<Launch>)= Hawk.put(CacheKey.PAST_LAUNCH, launches)
    fun setCacheLatestLaunch(launch: Launch)= Hawk.put(CacheKey.LATEST_LAUNCH, launch)
    fun setCacheHistoricalEvents(history: ArrayList<History>)= Hawk.put(CacheKey.HISTORICAL_EVENTS, history)
    fun setCacheAllRockets(rockets: ArrayList<Rockets>)= Hawk.put(CacheKey.ALL_ROCKETS, rockets)

}