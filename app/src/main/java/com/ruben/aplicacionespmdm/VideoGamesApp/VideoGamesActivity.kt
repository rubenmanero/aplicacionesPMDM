package com.ruben.aplicacionespmdm.VideoGamesApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ruben.aplicacionespmdm.R
import com.ruben.aplicacionespmdm.SuperheroApp.SuperheroAdapter
import com.ruben.aplicacionespmdm.databinding.ActivityVideoGamesBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class VideoGamesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVideoGamesBinding
    private lateinit var retrofit: Retrofit
    //private lateinit var adapter: VideoGameAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoGamesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofit = getRetrofit()
    }


    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}