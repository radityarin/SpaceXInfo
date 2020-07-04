package com.radityarin.spacexinfo.ui.missions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.radityarin.spacexinfo.data.model.launches.Launch
import com.radityarin.spacexinfo.data.repository.Repository
import com.radityarin.spacexinfo.ui.base.BaseViewModel
import com.radityarin.spacexinfo.util.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class MissionsFragmentViewModel(
    private val repository: Repository
) : BaseViewModel() {

    private val _missionsListItem = MutableLiveData<ArrayList<Launch>>()
    val missionsListItem: LiveData<ArrayList<Launch>>
        get() = _missionsListItem

    fun getNextLaunch() {
        repository.getNextLaunch().observeOn(Schedulers.io())
            .subscribeOn(Schedulers.io())
            .subscribe({
            }, {
                it.printStackTrace()
            })
            .addTo(compositeDisposable)
    }

    fun getPastLaunch() {
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

    fun loadCachePastLaunch() {
        val cachePastLaunch = repository.getCachePastLaunch()
        if (cachePastLaunch == null) {
            getPastLaunch()
        } else {
            cachePastLaunch.reverse()
            _missionsListItem.postValue(cachePastLaunch)
        }
    }

    fun getUpcomingLaunch() {
        repository.getUpcomingLaunch().observeOn(Schedulers.io())
            .subscribeOn(Schedulers.io())
            .subscribe({
                _missionsListItem.postValue(it)
            }, {
                it.printStackTrace()
            })
            .addTo(compositeDisposable)
    }

    fun loadCacheUpcomingLaunch() {
        val cacheUpcomingLaunch = repository.getCacheUpcomingLaunch()
        if (cacheUpcomingLaunch == null) {
            getUpcomingLaunch()
        } else {
            _missionsListItem.postValue(repository.getCacheUpcomingLaunch())
        }
    }
}