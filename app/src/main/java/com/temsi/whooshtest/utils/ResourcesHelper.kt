package com.temsi.whooshtest.utils

import android.app.Application
import com.temsi.whooshtest.R

class ResourcesHelper(private val applicationContext: Application) {
    val wait
        get() = applicationContext.resources.getString(R.string.wait)

    val baseScooterName
        get() = applicationContext.resources.getString(R.string.baseScooterName)

    val connectToInternet
        get() = applicationContext.resources.getString(R.string.connectToInternet)
}