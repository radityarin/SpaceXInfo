package com.radityarin.spacexinfo.ui.missions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.radityarin.spacexinfo.data.model.launches.Launch
import com.radityarin.spacexinfo.data.repository.AppRepository
import com.radityarin.spacexinfo.util.addTo
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*
import kotlin.collections.ArrayList

class MissionsFragmentViewModel constructor(
    private val repository: AppRepository
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _missionsListItem = MutableLiveData<ArrayList<Launch>>()
    val missionsListItem: LiveData<ArrayList<Launch>>
        get() = _missionsListItem

    fun getAllLaunches(){
        repository.getAllLaunch().observeOn(Schedulers.io())
            .subscribeOn(Schedulers.io())
            .subscribe({
                _missionsListItem.postValue(it)
            }, {
                it.printStackTrace()
            })
            .addTo(compositeDisposable)
    }

    fun getPastLaunch(){
        repository.getPastLaunch().observeOn(Schedulers.io())
            .subscribeOn(Schedulers.io())
            .subscribe({
                it.reverse()
                _missionsListItem.postValue(it)
            }, {
                it.printStackTrace()
            })
            .addTo(compositeDisposable)
    }

    fun getUpcomingLaunch(){
        repository.getUpcomingLaunch().observeOn(Schedulers.io())
            .subscribeOn(Schedulers.io())
            .subscribe({
                _missionsListItem.postValue(it)
            }, {
                it.printStackTrace()
            })
            .addTo(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}