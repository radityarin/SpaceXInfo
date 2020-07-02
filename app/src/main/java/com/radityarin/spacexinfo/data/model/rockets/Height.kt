package com.radityarin.spacexinfo.data.model.rockets


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Height(
    @SerializedName("feet")
    val feet: Float,
    @SerializedName("meters")
    val meters: Float
): Serializable