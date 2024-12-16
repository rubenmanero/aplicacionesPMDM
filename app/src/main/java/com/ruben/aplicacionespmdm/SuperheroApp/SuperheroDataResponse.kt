package com.ruben.aplicacionespmdm.SuperheroApp

import com.google.gson.annotations.SerializedName
data class SuperheroDataResponse (
    @SerializedName("response") val response: String,
    @SerializedName("results") val superheroes: List<SuperheroItemResponse>
)

data class SuperheroItemResponse (
    @SerializedName("id") val superheroId: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val superheroImage: SuperheroImageResponse
)

data class SuperheroImageResponse (
    @SerializedName("url") val url: String
)