package com.radityarin.spacexinfo

import android.app.Application
import com.radityarin.spacexinfo.di.appModule
import com.radityarin.spacexinfo.di.networkModule
import com.radityarin.spacexinfo.di.repositoryModule
import com.radityarin.spacexinfo.di.viewModelModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

class AppController : Application() {

    private val calConfig: CalligraphyConfig by inject()

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppController)
            modules(appModule)
            modules(networkModule)
            modules(viewModelModule)
            modules(repositoryModule)
        }

        CalligraphyConfig.initDefault(calConfig)

    }

}