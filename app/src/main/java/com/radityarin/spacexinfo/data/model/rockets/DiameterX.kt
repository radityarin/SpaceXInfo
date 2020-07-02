package com.radityarin.spacexinfo.data.model.rockets


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DiameterX(
    @SerializedName("feet")
    val feet: Any,
    @SerializedName("meters")
    val meters: Any
): Serializable