package com.parimatch.weathertest.screens.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.parimatch.weathertest.base.BaseViewModel
import com.parimatch.weathertest.screens.main.domain.MainInteractor
import com.parimatch.weathertest.screens.main.domain.WeatherDay

class MainViewModel(private val interactor: MainInteractor) : BaseViewModel<MainInteractor>(interactor) {

    val weatherLiveData: MutableLiveData<List<WeatherDay>> by lazy {
        MutableLiveData<List<WeatherDay>>().also{
            getWeather()
        }
    }

    val errorLiveData: MutableLiveData<String> = MutableLiveData()

    private fun getWeather() {
        interactor.getWeatherForecast({
            weatherLiveData.postValue(it)
        },{
            errorLiveData.postValue(it.message)
        })
    }

    class MainViewModelFactory(private val interactor: MainInteractor) : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(interactor) as T
        }
    }
}