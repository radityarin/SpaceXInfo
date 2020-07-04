package com.radityarin.spacexinfo.ui.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.radityarin.spacexinfo.data.model.historical.History
import com.radityarin.spacexinfo.data.repository.Repository
import com.radityarin.spacexinfo.ui.base.BaseViewModel
import com.radityarin.spacexinfo.util.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class HistoryFragmentViewModel(
    private val repository: Repository
) : BaseViewModel() {

    private val _historyListItems = MutableLiveData<ArrayList<History>>()
    val historyListItems: LiveData<ArrayList<History>>
        get() = _historyListItems

    fun getHistoricalEvents() {
        repository.getHistoricalEvents().observeOn(Schedulers.io())
            .subscribeOn(Schedulers.io())
            .subscribe({
                _historyListItems.postValue(it)
            }, {
                it.printStackTrace()
            })
            .addTo(compositeDisposable)
    }

    fun loadCacheHistoricalEvents() {
        val cacheHistoricalEvents = repository.getCacheHistoricalEvents()
        if (cacheHistoricalEvents == null) {
            getHistoricalEvents()
        } else {
            cacheHistoricalEvents.reverse()
            _historyListItems.postValue(cacheHistoricalEvents)
        }
    }
}