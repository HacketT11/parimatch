package com.parimatch.weathertest.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitServiceProvider: ServiceProvider{

    private companion object{
        const val API_KEY_PARAM = "appid"
    }

    private val retrofit: Retrofit = run {
        val okHttpBuilder = OkHttpClient.Builder()
            .addInterceptor {chain ->
                val request = chain.request().newBuilder()
                val originalHttpUrl = chain.request().url()
                val url = originalHttpUrl.newBuilder().addQueryParameter(API_KEY_PARAM, "ec2bd44f58eedb5fc754a094cfb459cb").build()
                request.url(url)
                return@addInterceptor chain.proceed(request.build())
            }

        val gson = GsonBuilder()
            .setLenient()
            .create()

            Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org")
            .client(okHttpBuilder.build())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    override fun <S> createService(serviceClass: Class<S>): S {
        return retrofit.create(serviceClass)
    }
}