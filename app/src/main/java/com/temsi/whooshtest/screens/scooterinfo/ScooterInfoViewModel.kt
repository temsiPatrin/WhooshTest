package com.temsi.whooshtest.screens.scooterinfo


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.temsi.whooshtest.entities.ScooterInfoModel
import com.temsi.whooshtest.repo.ScooterInfoRepo
import com.temsi.whooshtest.utils.ResourcesHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ScooterInfoViewModel(
    private val resourcesHelper: ResourcesHelper,
    private val repo: ScooterInfoRepo
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _scooterInfo = MutableLiveData<ScooterInfoModel>()
    val scooterInfo: LiveData<ScooterInfoModel>
        get() = _scooterInfo

    init {
        _scooterInfo.value = ScooterInfoModel(resourcesHelper.baseScooterName,
            resourcesHelper.wait, resourcesHelper.wait)
    }

    fun fetchScooterInfo(name: String) {
        compositeDisposable.add(
            repo.getScooterInfo(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { ScooterInfoModel(name, it.status, it.comments) }
                .subscribe({
                    _scooterInfo.postValue(it)
                }, {
                    _scooterInfo.postValue(ScooterInfoModel(resourcesHelper.baseScooterName,
                        resourcesHelper.connectToInternet, resourcesHelper.connectToInternet))
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}