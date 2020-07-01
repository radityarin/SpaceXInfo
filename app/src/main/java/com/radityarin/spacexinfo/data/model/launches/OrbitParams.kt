package com.radityarin.spacexinfo.data.model.launches


import com.google.gson.annotations.SerializedName

data class OrbitParams(
    @SerializedName("apoapsis_km")
    val apoapsisKm: Any,
    @SerializedName("arg_of_pericenter")
    val argOfPericenter: Any,
    @SerializedName("eccentricity")
    val eccentricity: Any,
    @SerializedName("epoch")
    val epoch: Any,
    @SerializedName("inclination_deg")
    val inclinationDeg: Any,
    @SerializedName("lifespan_years")
    val lifespanYears: Int,
    @SerializedName("longitude")
    val longitude: Any,
    @SerializedName("mean_anomaly")
    val meanAnomaly: Any,
    @SerializedName("mean_motion")
    val meanMotion: Any,
    @SerializedName("periapsis_km")
    val periapsisKm: Any,
    @SerializedName("period_min")
    val periodMin: Any,
    @SerializedName("raan")
    val raan: Any,
    @SerializedName("reference_system")
    val referenceSystem: String,
    @SerializedName("regime")
    val regime: String,
    @SerializedName("semi_major_axis_km")
    val semiMajorAxisKm: Any
)