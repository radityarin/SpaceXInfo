package com.radityarin.spacexinfo.data.model.rockets


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SecondStage(
    @SerializedName("burn_time_sec")
    val burnTimeSec: Any,
    @SerializedName("engines")
    val engines: Int,
    @SerializedName("fuel_amount_tons")
    val fuelAmountTons: Float,
    @SerializedName("payloads")
    val payloads: Payloads,
    @SerializedName("reusable")
    val reusable: Boolean,
    @SerializedName("thrust")
    val thrust: Thrust
): Serializable