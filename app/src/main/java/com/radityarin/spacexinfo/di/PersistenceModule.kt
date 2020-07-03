package com.radityarin.spacexinfo.di

import com.radityarin.spacexinfo.data.source.pref.AppPrefSource
import org.koin.dsl.module

val persistenceModule = module {
    single {
        AppPrefSource()
    }
}