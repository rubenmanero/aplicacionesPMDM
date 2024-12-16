package com.ruben.aplicacionespmdm.SuperheroApp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.ruben.aplicacionespmdm.databinding.ActivitySuperheroListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class SuperheroListActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuperheroListBinding
    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperheroListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofit = getRetrofit()
        initUI()

    }

    private fun initUI() {
        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?) = false

        })
    }

    private fun searchByName(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<SuperheroDataResponse> =
                retrofit
                .create(ApiService::class.java)
                .getSuperheroes(query)
            if(myResponse.isSuccessful) {
                Log.i("Consulta", "Funciona :)")
            } else {
                Log.i("Consulta", "No funciona :(")
            }
        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/api/cf7418614ae06050036a16ba11287d07/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}