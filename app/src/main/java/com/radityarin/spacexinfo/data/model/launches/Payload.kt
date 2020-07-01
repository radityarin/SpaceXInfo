package com.radityarin.spacexinfo.data.model.launches


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

data class Payload(
    @SerializedName("customers")
    val customers: List<String>,
    @SerializedName("manufacturer")
    val manufacturer: String,
    @SerializedName("nationality")
    val nationality: String,
    @SerializedName("norad_id")
    val noradId: List<String>,
    @SerializedName("orbit")
    val orbit: String,
    @SerializedName("orbit_params")
    val orbitParams: OrbitParams,
    @SerializedName("payload_id")
    val payloadId: String,
    @SerializedName("payload_mass_kg")
    val payloadMassKg: String,
    @SerializedName("payload_mass_lbs")
    val payloadMassLbs: String,
    @SerializedName("payload_type")
    val payloadType: String,
    @SerializedName("reused")
    val reused: Boolean
): Serializable