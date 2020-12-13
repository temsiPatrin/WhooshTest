package com.temsi.whooshtest.repo

import com.temsi.whooshtest.api.ScooterApi
import com.temsi.whooshtest.entities.ScooterInfo
import io.reactivex.Single

class ScooterInfoRepoImpl(private val api: ScooterApi) : ScooterInfoRepo {
    override fun getScooterInfo(code: String): Single<ScooterInfo> {
        return api.getScooterInfo(code)
    }
}