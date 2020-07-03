package com.radityarin.spacexinfo

import android.app.Application
import android.content.ContentValues
import android.util.Log
import com.orhanobut.hawk.Hawk
import com.radityarin.spacexinfo.di.*
import com.radityarin.spacexinfo.util.Constant.HAWK
import io.reactivex.rxjava3.plugins.RxJavaPlugins
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
            modules(persistenceModule)
        }

        CalligraphyConfig.initDefault(calConfig)

        Hawk.init(applicationContext).setLogInterceptor { message ->
            if (BuildConfig.DEBUG) {
                Log.d(HAWK, message)
            }
        }.build()

        RxJavaPlugins.setErrorHandler {
            Log.d(ContentValues.TAG, it.message.toString())
        }
    }

}