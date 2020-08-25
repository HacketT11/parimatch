package com.parimatch.weathertest.di

import com.parimatch.weathertest.WeatherApp
import com.parimatch.weathertest.network.ServiceProvider
import com.parimatch.weathertest.utils.photo.PhotoLoader
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(app: WeatherApp)

    fun serviceProvider(): ServiceProvider

    fun photoLoader(): PhotoLoader
}