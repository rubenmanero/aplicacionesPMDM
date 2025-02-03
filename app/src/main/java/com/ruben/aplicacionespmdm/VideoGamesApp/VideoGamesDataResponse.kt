package com.ruben.aplicacionespmdm.VideoGamesApp

import com.google.gson.annotations.SerializedName

data class VideoGameDataResponse(
    @SerializedName("count") val response: Int,
    @SerializedName("results") val videogames: List<VideoGameItemResponse>
)

data class VideoGameItemResponse (
    @SerializedName("name") val name: String,
    @SerializedName("rating") val rating: Float,
    @SerializedName("released") val releaseDate: String,
    @SerializedName("background_image") val videogameImage: String,
    @SerializedName("platforms") val platforms: List<PlatformsResponse>
)

data class PlatformsResponse (
    @SerializedName("platform") val platform: PlatformName
)

data class PlatformName (
    @SerializedName("name") val platformName: String
)