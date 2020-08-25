package com.parimatch.weathertest.data.weather


//doing without @SerializedName

data class WeatherResponse(
    val id: Int,
    val daily: List<Daily>
)

data class Temp(
    var day: Double,
    var min: Double,
    var max: Double,
    var night: Double,
    var eve: Double,
    var morn: Double
)

data class FeelsLike(
    var day: Double,
    var night: Double,
    var eve: Double,
    var morn: Double
)

data class Weather(
    var id: Int,
    var main: String,
    var description: String,
    var icon: String
)

data class Daily(
    var dt: Int,
    var sunrise: Int,
    var sunset: Int,
    var temp: Temp,
    var feels_like: FeelsLike,
    var pressure: Double,
    var humidity: Double,
    var dew_point: Double,
    var wind_speed: Double,
    var wind_deg: Double,
    var weather: List<Weather>,
    var clouds: Double,
    var pop: Double,
    var rain: Double,
    var uvi: Double
)