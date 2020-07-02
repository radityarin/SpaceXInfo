package com.radityarin.spacexinfo.data.model.launches


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SecondStage(
    @SerializedName("block")
    val block: Int,
    @SerializedName("payloads")
    val payloads: List<Payload>
): Serializable