package com.ruben.aplicacionespmdm.VideoGamesApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
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
        initUI()
    }

    private fun initUI() {
        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(query: String?): Boolean {
                //searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?) = false
        })
        //adapter = VideoGameAdapter()
        binding.rvSuperhero.setHasFixedSize(true)
        binding.rvSuperhero.layoutManager = LinearLayoutManager(this)
        //binding.rvSuperhero.adapter = adapter
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://api.rawg.io/api/platforms?key=2a87fee229814f178343d360c47b4ccb")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}