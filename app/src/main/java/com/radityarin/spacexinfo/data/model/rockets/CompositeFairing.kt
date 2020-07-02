package com.radityarin.spacexinfo.data.model.rockets


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CompositeFairing(
    @SerializedName("diameter")
    val diameter: DiameterX,
    @SerializedName("height")
    val height: HeightX
): Serializable