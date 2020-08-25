package com.parimatch.weathertest.screens.main.domain

import com.parimatch.weathertest.base.BaseInteractor
import com.parimatch.weathertest.data.weather.WeatherRepository
import com.parimatch.weathertest.data.weather.WeatherResponse
import com.parimatch.weathertest.utils.getDayFromTimestamp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainInteractor(private val weatherRepository: WeatherRepository) : BaseInteractor() {

    private companion object {
        const val KELVIN_TEMP_DIFF = 273.15
        const val KYIV_LONGTITUDE = 50.545
        const val KYIV_LATITUDE = 30.523
    }

    fun getWeatherForecast(onSuccess: (List<WeatherDay>) -> Unit, onError: (Throwable) -> Unit) {
        interactorScope.launch {
            val response =
                withContext(Dispatchers.IO) { weatherRepository.getWeatherForecast(KYIV_LONGTITUDE, KYIV_LATITUDE) }
            response.body()?.let { onSuccess(mapWeatherData(it)) }
            response.errorBody()?.let { onError(Exception("Network Error.")) }
        }
    }

    private fun mapWeatherData(weatherResponse: WeatherResponse): List<WeatherDay> {
        return weatherResponse.daily.map {
            WeatherDay(
                humidity = it.humidity,
                windSpeed = it.wind_speed,
                temperature = (it.temp.eve - KELVIN_TEMP_DIFF).toInt(),
                description = it.weather.first().description,
                date = getDayFromTimestamp(it.dt.toLong())
            )
        }
    }
}
