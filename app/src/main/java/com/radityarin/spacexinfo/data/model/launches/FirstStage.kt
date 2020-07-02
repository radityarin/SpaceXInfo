package com.radityarin.spacexinfo.data.model.launches


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FirstStage(
    @SerializedName("cores")
    val cores: List<Core>
): Serializable