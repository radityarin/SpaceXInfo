package com.radityarin.spacexinfo.ui.missions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.radityarin.spacexinfo.data.model.launches.Launches
import com.radityarin.spacexinfo.data.model.launches.LaunchesItem
import com.radityarin.spacexinfo.data.repository.AppRepository
import io.reactivex.disposables.CompositeDisposable

class MissionsFragmentViewModel constructor(
    private val repository: AppRepository
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    var allLaunch : MutableLiveData<Launches> = MutableLiveData()
    var pastLaunch : MutableLiveData<Launches> = MutableLiveData()
    var upcomingLaunch : MutableLiveData<Launches> = MutableLiveData()
    var latestLaunch : MutableLiveData<LaunchesItem> = MutableLiveData()

    fun getAllLaunches(){
        repository.getAllLaunch(compositeDisposable) {
            allLaunch.postValue(it)
        }
    }

    fun getPastLaunch(){
        repository.getPastLaunch(compositeDisposable) {
            pastLaunch.postValue(it)
        }
    }

    fun getLatestLaunch(){
        repository.getLatestLaunch(compositeDisposable) {
            latestLaunch.postValue(it)
        }
    }

    fun getUpcomingLaunch(){
        repository.getUpcomingLaunch(compositeDisposable) {
            upcomingLaunch.postValue(it)
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}