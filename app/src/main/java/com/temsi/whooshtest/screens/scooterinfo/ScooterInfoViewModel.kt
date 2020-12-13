package com.temsi.whooshtest.screens.scooterinfo

import android.util.Log
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.temsi.whooshtest.entities.ScooterInfoModel
import com.temsi.whooshtest.repo.ScooterInfoRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ScooterInfoViewModel(val name : String,private val repo: ScooterInfoRepo) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _scooterInfo = MutableLiveData<ScooterInfoModel>()
    val scooterInfo: LiveData<ScooterInfoModel>
        get() = _scooterInfo

    init {
        _scooterInfo.value = ScooterInfoModel(name,"Подождите...","Подождите...")
        fetchScooterInfo(name)
    }

    private fun fetchScooterInfo(name: String) {
        compositeDisposable.add(
            repo.getScooterInfo(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { ScooterInfoModel(name,it.status,it.comments) }
                .subscribe({
                    _scooterInfo.postValue(it)
                }, {
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}