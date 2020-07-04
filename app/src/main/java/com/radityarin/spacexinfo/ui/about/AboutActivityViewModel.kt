package com.radityarin.spacexinfo.ui.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.radityarin.spacexinfo.data.model.company.Company
import com.radityarin.spacexinfo.data.repository.Repository
import com.radityarin.spacexinfo.ui.base.BaseViewModel
import com.radityarin.spacexinfo.util.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class AboutActivityViewModel (
    private val repository: Repository
) : BaseViewModel() {

    private val _aboutItems = MutableLiveData<Company>()
    val companyItems: LiveData<Company>
        get() = _aboutItems

    fun getAboutCompany() {
        repository.getAboutCompany().observeOn(Schedulers.io())
            .subscribeOn(Schedulers.io())
            .subscribe({
                _aboutItems.postValue(it)
            }, {
                it.printStackTrace()
            })
            .addTo(compositeDisposable)
    }
}