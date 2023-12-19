package com.ruben.aplicacionespmdm.ColorsApp

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ruben.aplicacionespmdm.R

class HorizontalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvVerticalBar: TextView = view.findViewById(R.id.tvVerticalBar)
    private val cvVerticalBar: CardView = view.findViewById(R.id.cvVerticalBar)

    fun render(verticalBar: VerticalBar) {
        tvVerticalBar.text = verticalBar.label
        cvVerticalBar.setCardBackgroundColor(verticalBar.colorSelected)
    }
}