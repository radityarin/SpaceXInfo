package com.radityarin.spacexinfo.ui.rockets

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.radityarin.spacexinfo.data.model.launches.LaunchesItem
import com.radityarin.spacexinfo.data.model.rockets.Rockets
import com.radityarin.spacexinfo.data.repository.AppRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable

class RocketFragmentViewModel constructor(
    private val repository: AppRepository
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    var allRockets : MutableLiveData<Rockets> = MutableLiveData()

    fun getAllRockets(){
        repository.getAllRockets(compositeDisposable) {
            allRockets.postValue(it)
        }
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}