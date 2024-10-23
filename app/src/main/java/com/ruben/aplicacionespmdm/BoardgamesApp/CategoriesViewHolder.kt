package com.ruben.aplicacionespmdm.BoardgamesApp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ruben.aplicacionespmdm.R

class CategoriesViewHolder(vista: View): RecyclerView.ViewHolder(vista) {
    private var tvCategoryName: TextView = vista.findViewById(R.id.tvCategoryName)
    private var divider: View = vista.findViewById(R.id.divider)

    fun render(gameCategory: GameCategory) {

    }
}