package com.temsi.whooshtest.api

import com.temsi.whooshtest.entities.ScooterInfo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ScooterApi {
    @GET("challenge/getinfo")
    @Headers("x-api-key: zJouBcMNMLaG5WhE6LyWMav1vMuFON896ucKSjIm")
    fun getScooterInfo(@Query("code") code: String): Single<ScooterInfo>
}