package com.radityarin.spacexinfo.di

import com.radityarin.spacexinfo.data.source.remote.Api
import com.radityarin.spacexinfo.data.source.remote.AppRemoteSource
import com.radityarin.spacexinfo.util.Constant
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    single {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        OkHttpClient().newBuilder()
            .connectTimeout(Constant.NETWORK_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(Constant.NETWORK_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(Constant.NETWORK_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(
                httpLoggingInterceptor.apply {
                    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    single {
        AppRemoteSource(get())
    }

    single {
        Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .client(get<OkHttpClient>())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(Api::class.java)
    }


}