package com.temsi.whooshtest.di

import com.temsi.whooshtest.screens.scooterinfo.ScooterInfoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ScooterInfoViewModel(get(), get()) }
}