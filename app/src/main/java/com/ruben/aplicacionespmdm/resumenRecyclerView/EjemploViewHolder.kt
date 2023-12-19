package com.ruben.aplicacionespmdm.resumenRecyclerView

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ruben.aplicacionespmdm.ColorsApp.VerticalBar
import com.ruben.aplicacionespmdm.R

class EjemploViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    private val tvEjemplo: TextView = view.findViewById(R.id.tvEjemplo)

    fun pintarViews(item: TextoEjemplo) {
        tvEjemplo.text = item.texto
        tvEjemplo.setTextColor(item.colorTexto)
    }
}