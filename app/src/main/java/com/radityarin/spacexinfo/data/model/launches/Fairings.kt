package com.radityarin.spacexinfo.data.model.launches


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

data class Fairings(
    @SerializedName("recovered")
    val recovered: String,
    @SerializedName("recovery_attempt")
    val recoveryAttempt: String,
    @SerializedName("reused")
    val reused: String,
    @SerializedName("ship")
    val ship: String
): Serializable