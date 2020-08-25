package com.parimatch.weathertest.di

import android.content.Context
import com.parimatch.weathertest.network.RetrofitServiceProvider
import com.parimatch.weathertest.network.ServiceProvider
import com.parimatch.weathertest.utils.photo.GlidePhotoLoader
import com.parimatch.weathertest.utils.photo.PhotoLoader
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ApplicationModule(private val context: Context){

    @Provides
    fun provideApplicationContext(): Context = context

    @Provides
    @Singleton
    fun provideServiceProvider(): ServiceProvider = RetrofitServiceProvider()

    @Provides
    @Singleton
    fun providePhotoLoader(): PhotoLoader = GlidePhotoLoader()

    //provide preferences, Schedulers, some repositories that needs to be alive all the time etc.
}