package com.temsi.whooshtest

import android.app.Application
import com.temsi.whooshtest.di.apiModule
import com.temsi.whooshtest.di.repoModule
import com.temsi.whooshtest.di.utilsModule
import com.temsi.whooshtest.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            koin.loadModules(listOf(
                apiModule,
                repoModule,
                viewModelModule,
                utilsModule
            ))
            koin.createRootScope()
        }
    }
}