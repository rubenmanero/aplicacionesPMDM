package com.ruben.aplicacionespmdm.resumenRecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ruben.aplicacionespmdm.R

class EjemploAdapter (private val ejemplos: List<TextoEjemplo>) : RecyclerView.Adapter<EjemploViewHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EjemploViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ejemplo, parent, false)
        return EjemploViewHolder(view)
    }

    override fun onBindViewHolder(holder: EjemploViewHolder, position: Int) {
        holder.pintarViews(ejemplos[position])
    }

    override fun getItemCount(): Int {
        return ejemplos.size
    }
}