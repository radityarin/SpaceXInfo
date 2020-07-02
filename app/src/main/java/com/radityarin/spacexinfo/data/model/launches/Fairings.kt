package com.radityarin.spacexinfo.data.model.launches


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Fairings(
    @SerializedName("recovered")
    val recovered: Any,
    @SerializedName("recovery_attempt")
    val recoveryAttempt: Any,
    @SerializedName("reused")
    val reused: Any,
    @SerializedName("ship")
    val ship: Any
): Serializable