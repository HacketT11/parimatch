package com.parimatch.weathertest.utils.photo

import android.widget.ImageView
import com.bumptech.glide.Glide

class GlidePhotoLoader : PhotoLoader{

    override fun loadPhoto(id: Int, view: ImageView) {
        Glide.with(view).load(id).into(view)
    }
}