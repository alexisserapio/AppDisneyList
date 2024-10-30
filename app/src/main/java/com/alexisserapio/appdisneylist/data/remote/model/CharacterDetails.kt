package com.alexisserapio.appdisneylist.data.remote.model

import com.google.gson.annotations.SerializedName

class CharacterDetails(
    @SerializedName("name")
    var name:String,
    @SerializedName("imageUrl")
    var imageUrl:String,
    @SerializedName("films")
    var films:String
)