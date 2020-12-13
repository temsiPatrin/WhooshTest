package com.temsi.whooshtest.di

import com.temsi.whooshtest.api.ScooterApi
import com.temsi.whooshtest.repo.ScooterInfoRepo
import com.temsi.whooshtest.repo.ScooterInfoRepoImpl
import org.koin.dsl.module

val repoModule = module {
    fun provideScooterInfoRepo(api:ScooterApi): ScooterInfoRepo {
        return ScooterInfoRepoImpl(api)
    }
    factory { provideScooterInfoRepo(get()) }
}