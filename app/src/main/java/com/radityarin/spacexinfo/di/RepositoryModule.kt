package com.radityarin.spacexinfo.di

import com.radityarin.spacexinfo.data.repository.AppRepository
import com.radityarin.spacexinfo.data.repository.Repository
import org.koin.dsl.module

val repositoryModule = module {
    factory<Repository> {
        AppRepository(get(),get())
    }
}