package com.temsi.whooshtest.di

import android.app.Application
import com.temsi.whooshtest.utils.ResourcesHelper
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val utilsModule = module {
    fun provideResourcesHelper(applicationContext: Application):ResourcesHelper{
        return ResourcesHelper(applicationContext)
    }

    factory { provideResourcesHelper(androidApplication()) }
}