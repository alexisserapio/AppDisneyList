package com.alexisserapio.appdisneylist.data.remote.model

import com.google.gson.annotations.SerializedName


data class CharacterDetailsResponse(
    @SerializedName("data") val data: CharacterDetails
)
data class CharacterDetails(
    @SerializedName("name")
    var name:String,
    @SerializedName("imageUrl")
    var imageUrl:String,
    @SerializedName("films")
    var films:List<String>
)