package com.ruben.aplicacionespmdm.ColorsApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ruben.aplicacionespmdm.R


class HorizontalAdapter (private val verticalBars: List<VerticalBar>) : RecyclerView.Adapter<HorizontalViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_vertical_bar, parent, false)
        return HorizontalViewHolder(view)
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        holder.render(verticalBars[position])
    }

    override fun getItemCount() = verticalBars.size

}