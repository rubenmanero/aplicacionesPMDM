package com.ruben.aplicacionespmdm.VideoGamesApp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RAWGinterface {
    @GET("games?key=2a87fee229814f178343d360c47b4ccb&page_size=40")
    suspend fun getVideoGames(@Query("search") videogameName: String): Response<VideoGameDataResponse>
}