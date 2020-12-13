package com.temsi.whooshtest.screens.scooterinfo

import androidx.lifecycle.ViewModel
import com.temsi.whooshtest.repo.ScooterInfoRepo

class ScooterInfoViewModel(val name : String,private val repo: ScooterInfoRepo) : ViewModel() {

}