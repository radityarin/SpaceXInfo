package com.radityarin.spacexinfo.data.repository

import com.radityarin.spacexinfo.data.ApiObserver
import com.radityarin.spacexinfo.data.model.historical.History
import com.radityarin.spacexinfo.data.model.launches.Launches
import com.radityarin.spacexinfo.data.model.launches.LaunchesItem
import com.radityarin.spacexinfo.data.source.Api
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AppRepository(private val api: Api) : Repository {

    override fun getAllLaunch(
        compositeDisposable: CompositeDisposable,
        onResult: (Launches) -> Unit
    ) {
        api.getAllLaunch()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiObserver<Launches>(compositeDisposable) {
                override fun onApiSuccess(data: Launches) {
                    onResult(data)
                }

                override fun onApiError(er: Throwable) {
                    onError(er)
                }
            })
    }

    override fun getPastLaunch(
        compositeDisposable: CompositeDisposable,
        onResult: (Launches) -> Unit
    ) {
        api.getPastLaunch()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiObserver<Launches>(compositeDisposable) {
                override fun onApiSuccess(data: Launches) {
                    onResult(data)
                }

                override fun onApiError(er: Throwable) {
                    onError(er)
                }
            })
    }

    override fun getUpcomingLaunch(
        compositeDisposable: CompositeDisposable,
        onResult: (Launches) -> Unit
    ) {
        api.getUpcomingLaunch()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiObserver<Launches>(compositeDisposable) {
                override fun onApiSuccess(data: Launches) {
                    onResult(data)
                }

                override fun onApiError(er: Throwable) {
                    onError(er)
                }
            })
    }

    override fun getLatestLaunch(
        compositeDisposable: CompositeDisposable,
        onResult: (LaunchesItem) -> Unit
    ) {
        api.getLatestLaunch()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiObserver<LaunchesItem>(compositeDisposable) {
                override fun onApiSuccess(data: LaunchesItem) {
                    onResult(data)
                }

                override fun onApiError(er: Throwable) {
                    onError(er)
                }
            })
    }

    override fun getHistoricalEvents(
        compositeDisposable: CompositeDisposable,
        onResult: (History) -> Unit
    ) {
        api.getHistoricalEvents()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiObserver<History>(compositeDisposable) {
                override fun onApiSuccess(data: History) {
                    onResult(data)
                }

                override fun onApiError(er: Throwable) {
                    onError(er)
                }
            })
    }

}
