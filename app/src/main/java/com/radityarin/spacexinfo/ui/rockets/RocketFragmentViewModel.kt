package com.radityarin.spacexinfo.ui.rockets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.radityarin.spacexinfo.data.model.rockets.Rockets
import com.radityarin.spacexinfo.data.repository.AppRepository
import com.radityarin.spacexinfo.util.addTo
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class RocketFragmentViewModel constructor(
    private val repository: AppRepository
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _rocketsListItems = MutableLiveData<ArrayList<Rockets>>()
    val rocketsListItems: LiveData<ArrayList<Rockets>>
        get() = _rocketsListItems

    fun getAllRockets(){
        repository.getAllRockets().observeOn(Schedulers.io())
            .subscribeOn(Schedulers.io())
            .subscribe({
                _rocketsListItems.postValue(it)
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