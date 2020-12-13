package com.temsi.whooshtest.repo

import com.temsi.whooshtest.entities.ScooterInfo
import io.reactivex.Single

interface ScooterInfoRepo {
    fun getScooterInfo(code: String): Single<ScooterInfo>
}