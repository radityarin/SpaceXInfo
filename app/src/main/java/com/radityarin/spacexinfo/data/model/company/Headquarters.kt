package com.radityarin.spacexinfo.data.model.company


import com.google.gson.annotations.SerializedName

data class Headquarters(
    @SerializedName("address")
    val address: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("state")
    val state: String
)