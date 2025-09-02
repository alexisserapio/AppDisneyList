package com.alexisserapio.appdisneylist.data.remote

import com.alexisserapio.appdisneylist.data.remote.model.Character
import com.alexisserapio.appdisneylist.data.remote.model.CharacterDetails
import com.alexisserapio.appdisneylist.data.remote.model.CharacterDetailsResponse
import com.alexisserapio.appdisneylist.data.remote.model.CharacterResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface DisneyAPI {

    //Primer Endpoint
    @GET("character")
    fun getCharacters(@Query("pageSize") pageSize: Int): Call<CharacterResponse>

    /*@GET
    fun getCharacters(
        @Url url: String?
    ): Call<MutableList<Character>>*/

    /*@GET
    fun getCharacters(
        @Url url: String?
    ): Call<MutableList<Character>>*/

    //Segundo Endpoint
    //https://api.disneyapi.dev/character?pageSize=7438
    //https://api.disneyapi.dev/character/571

    @GET("character/{id}")
    fun getCharacterDetails(
        @Path("id") id: String?
    ):Call<CharacterDetailsResponse>

}