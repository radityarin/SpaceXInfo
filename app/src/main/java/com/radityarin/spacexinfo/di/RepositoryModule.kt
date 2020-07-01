package com.radityarin.spacexinfo.di

import com.radityarin.spacexinfo.data.repository.AppRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory {
        AppRepository(get())
    }
}