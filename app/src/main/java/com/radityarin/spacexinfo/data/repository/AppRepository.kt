package com.radityarin.spacexinfo.data.repository

import com.radityarin.spacexinfo.data.model.historical.History
import com.radityarin.spacexinfo.data.model.launches.Launch
import com.radityarin.spacexinfo.data.model.rockets.Rockets
import com.radityarin.spacexinfo.data.source.pref.AppPrefSource
import com.radityarin.spacexinfo.data.source.remote.AppRemoteSource
import io.reactivex.rxjava3.core.Observable

class AppRepository(private val api: AppRemoteSource, private val pref: AppPrefSource) :
    Repository {

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

    override fun getHistoricalEvents(): Observable<ArrayList<History>> {
        val cacheHistoricalEvents = getCacheHistoricalEvents()
        val localObservable = if (cacheHistoricalEvents != null) Observable.just(cacheHistoricalEvents)
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

//    override fun getPastLaunch(
//        compositeDisposable: CompositeDisposable,
//        onResult: (Launches) -> Unit
//    ) {
//        api.getPastLaunch()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(object : ApiObserver<Launches>(compositeDisposable) {
//                override fun onApiSuccess(data: Launches) {
//                    Collections.reverse(data)
//                    onResult(data)
//                }
//
//                override fun onApiError(er: Throwable) {
//                    onError(er)
//                }
//            })
//    }
//
//    override fun getUpcomingLaunch(
//        compositeDisposable: CompositeDisposable,
//        onResult: (Launches) -> Unit
//    ) {
//        api.getUpcomingLaunch()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(object : ApiObserver<Launches>(compositeDisposable) {
//                override fun onApiSuccess(data: Launches) {
//                    onResult(data)
//                }
//
//                override fun onApiError(er: Throwable) {
//                    onError(er)
//                }
//            })
//    }
//
//    override fun getLatestLaunch(
//        compositeDisposable: CompositeDisposable,
//        onResult: (LaunchesItem) -> Unit
//    ) {
//        api.getLatestLaunch()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(object : ApiObserver<LaunchesItem>(compositeDisposable) {
//                override fun onApiSuccess(data: LaunchesItem) {
//                    onResult(data)
//                }
//
//                override fun onApiError(er: Throwable) {
//                    onError(er)
//                }
//            })
//    }
//
//    override fun getHistoricalEvents(
//        compositeDisposable: CompositeDisposable,
//        onResult: (History) -> Unit
//    ) {
//        api.getHistoricalEvents()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(object : ApiObserver<History>(compositeDisposable) {
//                override fun onApiSuccess(data: History) {
//                    onResult(data)
//                }
//
//                override fun onApiError(er: Throwable) {
//                    onError(er)
//                }
//            })
//    }
//
//    override fun getAllRockets(
//        compositeDisposable: CompositeDisposable,
//        onResult: (Rockets) -> Unit
//    ) {
//        api.getAllRockets()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(object : ApiObserver<Rockets>(compositeDisposable) {
//                override fun onApiSuccess(data: Rockets) {
//                    onResult(data)
//                }
//
//                override fun onApiError(er: Throwable) {
//                    onError(er)
//                }
//            })
//    }

    override fun getCacheAllLaunch(): ArrayList<Launch>? = pref.getAllLaunch()
    override fun getCachePastLaunch(): ArrayList<Launch>? = pref.getPastLaunch()
    override fun getCacheUpcomingLaunch(): ArrayList<Launch>? = pref.getUpcomingLaunch()
    override fun getCacheLatestLaunch(): Launch? = pref.getLatestLaunch()
    override fun getCacheHistoricalEvents(): ArrayList<History>? = pref.getHistoricalEvents()
    override fun getCacheAllRockets(): ArrayList<Rockets>? = pref.getAllRockets()

    private fun setCacheAllLaunch(launches: ArrayList<Launch>) = pref.setCacheAllLaunch(launches)
    private fun setCachePastLaunch(launches: ArrayList<Launch>) = pref.setCachePastLaunch(launches)
    private fun setCacheUpcomingLaunch(launches: ArrayList<Launch>) = pref.setCacheUpcomingLaunch(launches)
    private fun setCacheLatestLaunch(launch: Launch) = pref.setCacheLatestLaunch(launch)
    private fun setCacheHistoricalEvents(history: ArrayList<History>) = pref.setCacheHistoricalEvents(history)
    private fun setCacheAllRockets(rockets: ArrayList<Rockets>) = pref.setCacheAllRockets(rockets)

}
