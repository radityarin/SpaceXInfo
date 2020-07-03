package com.radityarin.spacexinfo.di

import com.radityarin.spacexinfo.R
import com.radityarin.spacexinfo.util.DEFAULT_FONT
import org.koin.dsl.module
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

val appModule = module {

    single {
        CalligraphyConfig.Builder()
            .setDefaultFontPath(DEFAULT_FONT)
            .setFontAttrId(R.attr.fontPath)
            .build()
    }

}