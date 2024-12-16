package com.ruben.aplicacionespmdm.SuperheroApp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("search/{name}")
    suspend fun getSuperheroes (@Path("name") superheroName:String)
    : Response<SuperheroDataResponse>

    //@GET("{id}")
    //suspend fun getSuperheroDetail (@Path("id") superheroId:String)
    //:Response<SuperheroDetailResponse>
}