package com.ruben.aplicacionespmdm.VideoGamesApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ruben.aplicacionespmdm.R

class VideoGamesAdapter(var videogamesList: List<VideoGameItemResponse> = emptyList() ) : RecyclerView.Adapter<VideoGamesViewHolder>() {

    fun updateList(list: List<VideoGameItemResponse>) {
        videogamesList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoGamesViewHolder {
        return VideoGamesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_videogame, parent, false)
        )
    }
    override fun onBindViewHolder(holder: VideoGamesViewHolder, position: Int) {
        holder.bind(videogamesList[position])
    }
    override fun getItemCount() = videogamesList.size
}