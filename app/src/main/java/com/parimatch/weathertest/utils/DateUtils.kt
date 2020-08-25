package com.parimatch.weathertest.utils

import android.text.format.DateFormat

val dayFormat = "dd MMM"

fun getDayFromTimestamp(timestamp: Long): String {
    val formatter = DateFormat.format(dayFormat, timestamp * 1000)
    return formatter.toString()
}