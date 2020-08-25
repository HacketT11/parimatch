package com.parimatch.weathertest.screens.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.parimatch.weathertest.R
import com.parimatch.weathertest.WeatherApp
import com.parimatch.weathertest.data.weather.WeatherResponse
import com.parimatch.weathertest.screens.main.di.DaggerMainComponent
import com.parimatch.weathertest.screens.main.di.MainModule
import com.parimatch.weathertest.screens.main.domain.WeatherDay
import com.parimatch.weathertest.utils.photo.PhotoLoader
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    val component by lazy {
        DaggerMainComponent.builder()
            .mainModule(MainModule())
            .applicationComponent((application as WeatherApp).appComponent)
            .build()
    }

    @Inject
    lateinit var factory: MainViewModel.MainViewModelFactory
    lateinit var viewModel: MainViewModel

    @Inject
    lateinit var photoLoader: PhotoLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component.inject(this)
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        viewModel.weatherLiveData.observe(this, Observer {  initAdapter(it) })
        viewModel.errorLiveData.observe(this, Observer { showError(it) })

        photoLoader.loadPhoto(R.drawable.background, backgroundIv)
    }

    private fun initAdapter(weatherList: List<WeatherDay>) {
        val adapter = WeatherAdapter(weatherList)
        weatherRV.layoutManager = LinearLayoutManager(this)
        weatherRV.adapter = adapter
    }

    private fun showError(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
