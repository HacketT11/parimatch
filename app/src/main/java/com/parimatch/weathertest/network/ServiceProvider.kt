package com.parimatch.weathertest.network

interface ServiceProvider{

    fun <S> createService(serviceClass: Class<S>): S
}