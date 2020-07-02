package com.radityarin.spacexinfo

import android.app.Application
import android.content.ContentValues
import android.util.Log
import com.radityarin.spacexinfo.di.appModule
import com.radityarin.spacexinfo.di.networkModule
import com.radityarin.spacexinfo.di.repositoryModule
import com.radityarin.spacexinfo.di.viewModelModule
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppController : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppController)
            modules(appModule)
            modules(networkModule)
            modules(viewModelModule)
            modules(repositoryModule)
        }

        RxJavaPlugins.setErrorHandler {
            Log.d(ContentValues.TAG, it.message.toString())
        }
    }

}