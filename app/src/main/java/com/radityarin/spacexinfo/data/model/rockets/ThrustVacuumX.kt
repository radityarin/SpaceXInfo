package com.radityarin.spacexinfo.data.model.rockets


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ThrustVacuumX(
    @SerializedName("kN")
    val kN: Int,
    @SerializedName("lbf")
    val lbf: Int
): Serializable