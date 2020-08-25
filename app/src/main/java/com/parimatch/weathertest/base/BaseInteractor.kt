package com.parimatch.weathertest.base

import kotlinx.coroutines.*

abstract class BaseInteractor{

    private val job = SupervisorJob()

    protected val interactorScope  = CoroutineScope(Dispatchers.Main + job)

    open fun onClear(){
        interactorScope.coroutineContext.cancelChildren()
    }
}