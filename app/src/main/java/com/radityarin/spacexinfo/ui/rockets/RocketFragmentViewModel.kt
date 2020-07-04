package com.radityarin.spacexinfo.ui.rockets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.radityarin.spacexinfo.data.model.rockets.Rockets
import com.radityarin.spacexinfo.data.repository.Repository
import com.radityarin.spacexinfo.ui.base.BaseViewModel
import com.radityarin.spacexinfo.util.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class RocketFragmentViewModel(
    private val repository: Repository
) : BaseViewModel() {

    private val _rocketsListItems = MutableLiveData<ArrayList<Rockets>>()
    val rocketsListItems: LiveData<ArrayList<Rockets>>
        get() = _rocketsListItems

    fun getAllRockets() {
        repository.getAllRockets().observeOn(Schedulers.io())
            .subscribeOn(Schedulers.io())
            .subscribe({
                _rocketsListItems.postValue(it)
            }, {
                it.printStackTrace()
            })
            .addTo(compositeDisposable)
    }

    fun loadCacheAllRockets() {
        val cacheAllRockets = repository.getCacheAllRockets()
        if (cacheAllRockets == null) {
            getAllRockets()
        } else {
            cacheAllRockets.reverse()
            _rocketsListItems.postValue(cacheAllRockets)
        }
    }

}