package com.radityarin.spacexinfo.data.model.launches


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LaunchFailureDetails(
    @SerializedName("altitude")
    val altitude: Int,
    @SerializedName("reason")
    val reason: String,
    @SerializedName("time")
    val time: Int
): Serializable