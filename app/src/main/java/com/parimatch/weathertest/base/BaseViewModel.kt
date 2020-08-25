package com.parimatch.weathertest.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel<I : BaseInteractor>(private val interactor: I): ViewModel(){

    override fun onCleared() {
        super.onCleared()
        interactor.onClear()
    }
}