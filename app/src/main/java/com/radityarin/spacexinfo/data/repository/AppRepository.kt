package com.radityarin.spacexinfo.data.repository

import com.radityarin.spacexinfo.data.model.company.Company
import com.radityarin.spacexinfo.data.model.historical.History
import com.radityarin.spacexinfo.data.model.launches.Launch
import com.radityarin.spacexinfo.data.model.rockets.Rockets
import com.radityarin.spacexinfo.data.source.pref.AppPrefSource
import com.radityarin.spacexinfo.data.source.remote.AppRemoteSource
import io.reactivex.rxjava3.core.Observable

class AppRepository constructor(
    private val api: AppRemoteSource,
    private val pref: AppPrefSource
) : Repository {

    override fun getAllLaunch(): Observable<ArrayList<Launch>> {

        val cacheAllLaunch = getCacheAllLaunch()
        val localObservable = if (cacheAllLaunch != null) Observable.just(cacheAllLaunch)
        else Observable.empty()

        val remoteObservable = api.allLaunch()
            .flatMap {
                setCacheAllLaunch(it)
                Observable.just(it)
            }

        return Observable.concatArrayEager(localObservable, remoteObservable)
    }

    override fun getPastLaunch(): Observable<ArrayList<Launch>> {
        val cachePastLaunch = getCachePastLaunch()
        val localObservable = if (cachePastLaunch != null) Observable.just(cachePastLaunch)
        else Observable.empty()

        val remoteObservable = api.pastLaunch()
            .flatMap {
                setCachePastLaunch(it)
                Observable.just(it)
            }

        return Observable.concatArrayEager(localObservable, remoteObservable)
    }

    override fun getUpcomingLaunch(): Observable<ArrayList<Launch>> {
        val cacheUpcomingLaunch = getCacheUpcomingLaunch()
        val localObservable = if (cacheUpcomingLaunch != null) Observable.just(cacheUpcomingLaunch)
        else Observable.empty()

        val remoteObservable = api.upcomingLaunch()
            .flatMap {
                setCacheUpcomingLaunch(it)
                Observable.just(it)
            }

        return Observable.concatArrayEager(localObservable, remoteObservable)
    }

    override fun getLatestLaunch(): Observable<Launch> {
        val cacheLatestLaunch = getCacheLatestLaunch()
        val localObservable = if (cacheLatestLaunch != null) Observable.just(cacheLatestLaunch)
        else Observable.empty()

        val remoteObservable = api.latestLaunch()
            .flatMap {
                setCacheLatestLaunch(it)
                Observable.just(it)
            }

        return Observable.concatArrayEager(localObservable, remoteObservable)
    }


    override fun getNextLaunch(): Observable<Launch> {
        val cacheNextLaunch = getCacheNextLaunch()
        val localObservable = if (cacheNextLaunch != null) Observable.just(cacheNextLaunch)
        else Observable.empty()

        val remoteObservable = api.nextLaunch()
            .flatMap {
                setCacheNextLaunch(it)
                Observable.just(it)
            }

        return Observable.concatArrayEager(localObservable, remoteObservable)
    }

    override fun getHistoricalEvents(): Observable<ArrayList<History>> {
        val cacheHistoricalEvents = getCacheHistoricalEvents()
        val localObservable =
            if (cacheHistoricalEvents != null) Observable.just(cacheHistoricalEvents)
            else Observable.empty()

        val remoteObservable = api.historicalEvents()
            .flatMap {
                setCacheHistoricalEvents(it)
                Observable.just(it)
            }

        return Observable.concatArrayEager(localObservable, remoteObservable)
    }

    override fun getAllRockets(): Observable<ArrayList<Rockets>> {
        val cacheAllRockets = getCacheAllRockets()
        val localObservable = if (cacheAllRockets != null) Observable.just(cacheAllRockets)
        else Observable.empty()

        val remoteObservable = api.allRockets()
            .flatMap {
                setCacheAllRockets(it)
                Observable.just(it)
            }

        return Observable.concatArrayEager(localObservable, remoteObservable)
    }

    override fun getAboutCompany(): Observable<Company> {
        val cacheAboutCompany = getCacheAboutCompany()
        val localObservable = if (cacheAboutCompany != null) Observable.just(cacheAboutCompany)
        else Observable.empty()

        val remoteObservable = api.aboutCompany()
            .flatMap {
                setCacheAboutCompany(it)
                Observable.just(it)
            }

        return Observable.concatArrayEager(localObservable, remoteObservable)    }

    override fun getCacheAllLaunch(): ArrayList<Launch>? = pref.getAllLaunch()
    override fun getCachePastLaunch(): ArrayList<Launch>? = pref.getPastLaunch()
    override fun getCacheUpcomingLaunch(): ArrayList<Launch>? = pref.getUpcomingLaunch()
    override fun getCacheLatestLaunch(): Launch? = pref.getLatestLaunch()
    override fun getCacheNextLaunch(): Launch? = pref.getNextLaunch()
    override fun getCacheHistoricalEvents(): ArrayList<History>? = pref.getHistoricalEvents()
    override fun getCacheAllRockets(): ArrayList<Rockets>? = pref.getAllRockets()
    override fun getCacheAboutCompany(): Company? = pref.getAboutCompany()
    private fun setCacheAllLaunch(launches: ArrayList<Launch>) = pref.setCacheAllLaunch(launches)
    private fun setCachePastLaunch(launches: ArrayList<Launch>) = pref.setCachePastLaunch(launches)
    private fun setCacheUpcomingLaunch(launches: ArrayList<Launch>) = pref.setCacheUpcomingLaunch(launches)
    private fun setCacheLatestLaunch(launch: Launch) = pref.setCacheLatestLaunch(launch)
    private fun setCacheNextLaunch(launch: Launch) = pref.setCacheNextLaunch(launch)
    private fun setCacheHistoricalEvents(history: ArrayList<History>) = pref.setCacheHistoricalEvents(history)
    private fun setCacheAllRockets(rockets: ArrayList<Rockets>) = pref.setCacheAllRockets(rockets)
    private fun setCacheAboutCompany(company: Company) = pref.setCacheAboutCompany(company)

}
