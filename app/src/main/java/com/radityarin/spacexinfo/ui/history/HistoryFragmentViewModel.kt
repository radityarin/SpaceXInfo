package com.radityarin.spacexinfo.ui.history

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.radityarin.spacexinfo.data.model.historical.History
import com.radityarin.spacexinfo.data.repository.AppRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable

class HistoryFragmentViewModel constructor(
    private val repository: AppRepository
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    var allHistoricalEvents : MutableLiveData<History> = MutableLiveData()

    fun getHistoricalEvents(){
        repository.getHistoricalEvents(compositeDisposable) {
            allHistoricalEvents.postValue(it)
        }
    }
}