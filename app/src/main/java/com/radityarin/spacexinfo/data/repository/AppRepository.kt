package com.radityarin.spacexinfo.data.repository

import android.util.Log
import com.radityarin.spacexinfo.data.ApiObserver
import com.radityarin.spacexinfo.data.model.launches.Launches
import com.radityarin.spacexinfo.data.model.launches.LaunchesItem
import com.radityarin.spacexinfo.data.source.Api
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AppRepository(private val api: Api) : Repository {

    override fun getAllLaunches(compositeDisposable: CompositeDisposable, onResult: (Launches) -> Unit) {
        api.getAllLaunches()
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

    override fun getUpcomingLaunches(compositeDisposable: CompositeDisposable,onResult: (Launches) -> Unit) {
        api.getUpcomingLaunches()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiObserver<Launches>(compositeDisposable) {
                override fun onApiSuccess(data: Launches) {
                    onResult(data)
                    Log.d("cek", data[0].missionName)
                }

                override fun onApiError(er: Throwable) {
                    onError(er)
                }
            })
    }

    override fun getLatestLaunches(compositeDisposable: CompositeDisposable,onResult: (LaunchesItem) -> Unit) {
        api.getLatestLaunches()
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

}
