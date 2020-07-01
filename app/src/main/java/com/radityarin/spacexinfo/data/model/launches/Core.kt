package com.radityarin.spacexinfo.data.model.launches


import com.google.gson.annotations.SerializedName

data class Core(
    @SerializedName("block")
    val block: Int,
    @SerializedName("core_serial")
    val coreSerial: Any,
    @SerializedName("flight")
    val flight: Any,
    @SerializedName("gridfins")
    val gridfins: Any,
    @SerializedName("land_success")
    val landSuccess: Any,
    @SerializedName("landing_intent")
    val landingIntent: Any,
    @SerializedName("landing_type")
    val landingType: Any,
    @SerializedName("landing_vehicle")
    val landingVehicle: Any,
    @SerializedName("legs")
    val legs: Any,
    @SerializedName("reused")
    val reused: Boolean
)