package com.ruben.aplicacionespmdm.BoardgamesApp

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.ruben.aplicacionespmdm.R

class CategoriesViewHolder(vista: View): RecyclerView.ViewHolder(vista) {
    private var tvCategoryName: TextView = vista.findViewById(R.id.tvCategoryName)
    private var divider: View = vista.findViewById(R.id.divider)
    private var viewContainer: CardView = vista.findViewById(R.id.viewContainer)

    fun render(gameCategory: GameCategory, onItemSelected: (Int) -> Unit) {

        val color = if (gameCategory.isSelected) {
            R.color.bgapp_background_card
        } else {
            R.color.bgapp_background_disabled
        }

        viewContainer.setCardBackgroundColor(getColor(viewContainer.context,color))

        itemView.setOnClickListener { onItemSelected(layoutPosition) }

        when(gameCategory) {
            GameCategory.Cooperative -> {
                tvCategoryName.text = "Cooperativos"
                divider.setBackgroundColor(getColor(divider.context, R.color.bgapp_cooperative_category))
            }
            GameCategory.LCG -> {
                tvCategoryName.text = "LCG"
                divider.setBackgroundColor(getColor(divider.context, R.color.bgapp_lcg_category))
            }
            GameCategory.Deckbuilding -> {
                tvCategoryName.text = "Deckbuilding"
                divider.setBackgroundColor(getColor(divider.context, R.color.bgapp_deckbuilding_category))
            }
            GameCategory.Euro -> {
                tvCategoryName.text = "Eurogames"
                divider.setBackgroundColor(getColor(divider.context, R.color.bgapp_euro_category))
            }
            GameCategory.Legacy -> {
                tvCategoryName.text = "Legacy"
                divider.setBackgroundColor(getColor(divider.context, R.color.bgapp_legacy_category))
            }
        }
    }
}