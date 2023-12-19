package com.ruben.aplicacionespmdm.resumenRecyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ruben.aplicacionespmdm.BoardgamesApp.GamesAdapter
import com.ruben.aplicacionespmdm.R

class RecyclerViewActivity : AppCompatActivity() {

    private val listaEjemplo = listOf(
        TextoEjemplo("Primer elemento", getColor(R.color.violet80)),
        TextoEjemplo("Segundo elemento", getColor(R.color.blue80)),
        TextoEjemplo("Tercer elemento", getColor(R.color.green80)),
        TextoEjemplo("Cuarto elemento", getColor(R.color.orange80)),
        TextoEjemplo("Quinto elemento", getColor(R.color.red80))
    )

    private lateinit var rvEjemplo: RecyclerView
    private lateinit var rvAdapter: EjemploAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        rvEjemplo = findViewById(R.id.rvEjemplo)
        rvAdapter = EjemploAdapter(listaEjemplo)

        rvEjemplo.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvEjemplo.adapter = rvAdapter
    }
}