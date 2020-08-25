package com.parimatch.weathertest.screens.main.di

import com.parimatch.weathertest.data.weather.WeatherRepository
import com.parimatch.weathertest.data.weather.WeatherRepositoryImpl
import com.parimatch.weathertest.data.weather.WeatherService
import com.parimatch.weathertest.di.annotations.ActivityScope
import com.parimatch.weathertest.network.ServiceProvider
import com.parimatch.weathertest.screens.main.domain.MainInteractor
import com.parimatch.weathertest.screens.main.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class MainModule{

    @Provides
    @ActivityScope
    fun provideViewModelFactory(interactor: MainInteractor): MainViewModel.MainViewModelFactory
        = MainViewModel.MainViewModelFactory(interactor)

    @Provides
    @ActivityScope
    fun provideMainInteractor(weatherRepository: WeatherRepository): MainInteractor
            = MainInteractor(weatherRepository)

    @Provides
    @ActivityScope
    fun provideWeatherRepository(weatherService: WeatherService): WeatherRepository
            = WeatherRepositoryImpl(weatherService)

    @Provides
    @ActivityScope
    fun provideWeatherService(serviceProvider: ServiceProvider) : WeatherService
            = serviceProvider.createService(WeatherService::class.java)
}