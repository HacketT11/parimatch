package com.parimatch.weathertest

import android.app.Application
import com.parimatch.weathertest.di.ApplicationComponent
import com.parimatch.weathertest.di.ApplicationModule
import com.parimatch.weathertest.di.DaggerApplicationComponent

class WeatherApp : Application(){

    val appComponent : ApplicationComponent by lazy{
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()

    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }
}