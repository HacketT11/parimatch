package com.parimatch.weathertest.screens.main.di

import com.parimatch.weathertest.di.ApplicationComponent
import com.parimatch.weathertest.di.annotations.ActivityScope
import com.parimatch.weathertest.screens.main.MainActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [MainModule::class] )
interface MainComponent{

    fun inject(activity: MainActivity)
}