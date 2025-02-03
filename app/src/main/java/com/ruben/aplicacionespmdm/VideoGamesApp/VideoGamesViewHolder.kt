package com.ruben.aplicacionespmdm.VideoGamesApp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ruben.aplicacionespmdm.databinding.ItemVideogameBinding
import com.squareup.picasso.Picasso

class VideoGamesViewHolder (view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemVideogameBinding.bind(view)

    fun bind(videogameItemResponse: VideoGameItemResponse) {
        binding.tvVideogameName.text = videogameItemResponse.name
        binding.tvReleased.text = videogameItemResponse.releaseDate
        var plataformas = ""
        for(i in 0..<videogameItemResponse.platforms.size) {
            val plataforma =  videogameItemResponse.platforms[i].platform.platformName
            plataformas += "$plataforma, "
        }
        binding.tvPlatforms.text = plataformas
        binding.tvRating.text = videogameItemResponse.rating.toString()
        Picasso.get().load(videogameItemResponse.videogameImage).into(binding.ivVideogame)
    }
}