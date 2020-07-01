package com.radityarin.spacexinfo.data.model.launches


import com.google.gson.annotations.SerializedName

data class Telemetry(
    @SerializedName("flight_club")
    val flightClub: Any
)