package com.radityarin.spacexinfo.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.radityarin.spacexinfo.data.model.launches.Launches
import com.radityarin.spacexinfo.data.model.launches.LaunchesItem
import com.radityarin.spacexinfo.data.repository.AppRepository
import io.reactivex.disposables.CompositeDisposable

class MainActivityViewModel constructor(
    private val repository: AppRepository
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    var allLaunches : MutableLiveData<Launches> = MutableLiveData()
    var upcomingLaunch : MutableLiveData<Launches> = MutableLiveData()
    var latestLaunch : MutableLiveData<LaunchesItem> = MutableLiveData()

    fun getAllLaunches(){
        repository.getAllLaunches(compositeDisposable) {
            allLaunches.postValue(it)
        }
    }

    fun getLatestLaunch(){
        repository.getLatestLaunches(compositeDisposable) {
            latestLaunch.postValue(it)
        }
    }

    fun getUpcomingLaunch(){
        repository.getUpcomingLaunches(compositeDisposable) {
            upcomingLaunch.postValue(it)
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}