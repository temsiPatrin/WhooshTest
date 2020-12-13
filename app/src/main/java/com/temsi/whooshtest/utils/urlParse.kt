package com.temsi.whooshtest.utils

import android.net.UrlQuerySanitizer

object NameFromUrl {
    fun getNameScooter(url: String): String {
        val sanitizer = UrlQuerySanitizer()
        sanitizer.allowUnregisteredParamaters = true
        sanitizer.parseUrl(url)
        return sanitizer.getValue("scooter_code")
    }
}