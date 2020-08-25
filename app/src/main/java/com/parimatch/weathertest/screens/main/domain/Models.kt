package com.parimatch.weathertest.screens.main.domain

import androidx.annotation.DrawableRes


data class WeatherDay(
        val date: String,
        val description: String,
        val temperature: Int,
        val windSpeed: Double,
        val humidity: Double)