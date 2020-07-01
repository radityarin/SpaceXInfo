package com.radityarin.spacexinfo.data.model.launches


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

data class OrbitParams(
    @SerializedName("apoapsis_km")
    val apoapsisKm: String,
    @SerializedName("arg_of_pericenter")
    val argOfPericenter: String,
    @SerializedName("eccentricity")
    val eccentricity: String,
    @SerializedName("epoch")
    val epoch: String,
    @SerializedName("inclination_deg")
    val inclinationDeg: String,
    @SerializedName("lifespan_years")
    val lifespanYears: Int,
    @SerializedName("longitude")
    val longitude: String,
    @SerializedName("mean_anomaly")
    val meanAnomaly: String,
    @SerializedName("mean_motion")
    val meanMotion: String,
    @SerializedName("periapsis_km")
    val periapsisKm: String,
    @SerializedName("period_min")
    val periodMin: String,
    @SerializedName("raan")
    val raan: String,
    @SerializedName("reference_system")
    val referenceSystem: String,
    @SerializedName("regime")
    val regime: String,
    @SerializedName("semi_major_axis_km")
    val semiMajorAxisKm: String
) : Serializable