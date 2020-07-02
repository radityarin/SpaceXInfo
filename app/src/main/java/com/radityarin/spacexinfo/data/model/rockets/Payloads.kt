package com.radityarin.spacexinfo.data.model.rockets


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Payloads(
    @SerializedName("composite_fairing")
    val compositeFairing: CompositeFairing,
    @SerializedName("option_1")
    val option1: String,
    @SerializedName("option_2")
    val option2: String
): Serializable