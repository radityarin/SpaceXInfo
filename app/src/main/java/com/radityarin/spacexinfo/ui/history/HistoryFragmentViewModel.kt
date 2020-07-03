package com.radityarin.spacexinfo.ui.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.radityarin.spacexinfo.data.model.historical.History
import com.radityarin.spacexinfo.data.repository.AppRepository
import com.radityarin.spacexinfo.util.addTo
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class HistoryFragmentViewModel constructor(
    private val repository: AppRepository
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val _historyListItems = MutableLiveData<ArrayList<History>>()
    val historyListItems: LiveData<ArrayList<History>>
        get() = _historyListItems

    fun getHistoricalEvents(){
        repository.getHistoricalEvents().observeOn(Schedulers.io())
            .subscribeOn(Schedulers.io())
            .subscribe({
                _historyListItems.postValue(it)
            }, {
                it.printStackTrace()
            })
            .addTo(compositeDisposable)
    }
}