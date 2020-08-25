package com.parimatch.weathertest.utils.photo

import android.widget.ImageView

interface PhotoLoader {

    fun loadPhoto(id: Int, view: ImageView)
}