package com.radityarin.spacexinfo.data.model.rockets


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FirstStage(
    @SerializedName("burn_time_sec")
    val burnTimeSec: Any,
    @SerializedName("engines")
    val engines: Int,
    @SerializedName("fuel_amount_tons")
    val fuelAmountTons: Float,
    @SerializedName("reusable")
    val reusable: Boolean,
    @SerializedName("thrust_sea_level")
    val thrustSeaLevel: ThrustSeaLevelX,
    @SerializedName("thrust_vacuum")
    val thrustVacuum: ThrustVacuumX
): Serializable