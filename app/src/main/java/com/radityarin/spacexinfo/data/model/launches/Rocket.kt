package com.radityarin.spacexinfo.data.model.launches


import com.google.gson.annotations.SerializedName

data class Rocket(
    @SerializedName("fairings")
    val fairings: Fairings,
    @SerializedName("first_stage")
    val firstStage: FirstStage,
    @SerializedName("rocket_id")
    val rocketId: String,
    @SerializedName("rocket_name")
    val rocketName: String,
    @SerializedName("rocket_type")
    val rocketType: String,
    @SerializedName("second_stage")
    val secondStage: SecondStage
)