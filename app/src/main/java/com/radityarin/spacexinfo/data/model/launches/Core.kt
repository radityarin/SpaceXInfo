package com.radityarin.spacexinfo.data.model.launches


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Core(
    @SerializedName("block")
    val block: Int,
    @SerializedName("core_serial")
    val coreSerial: String,
    @SerializedName("flight")
    val flight: String,
    @SerializedName("gridfins")
    val gridfins: String,
    @SerializedName("land_success")
    val landSuccess: String,
    @SerializedName("landing_intent")
    val landingIntent: String,
    @SerializedName("landing_type")
    val landingType: String,
    @SerializedName("landing_vehicle")
    val landingVehicle: String,
    @SerializedName("legs")
    val legs: String,
    @SerializedName("reused")
    val reused: Boolean
): Serializable