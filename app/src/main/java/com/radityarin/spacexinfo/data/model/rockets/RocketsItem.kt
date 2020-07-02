package com.radityarin.spacexinfo.data.model.rockets


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RocketsItem(
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("boosters")
    val boosters: Int,
    @SerializedName("company")
    val company: String,
    @SerializedName("cost_per_launch")
    val costPerLaunch: Int,
    @SerializedName("country")
    val country: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("diameter")
    val diameter: Diameter,
    @SerializedName("engines")
    val engines: Engines,
    @SerializedName("first_flight")
    val firstFlight: String,
    @SerializedName("first_stage")
    val firstStage: FirstStage,
    @SerializedName("flickr_images")
    val flickrImages: List<String>,
    @SerializedName("height")
    val height: Height,
    @SerializedName("id")
    val id: Int,
    @SerializedName("landing_legs")
    val landingLegs: LandingLegs,
    @SerializedName("mass")
    val mass: Mass,
    @SerializedName("payload_weights")
    val payloadWeights: List<PayloadWeight>,
    @SerializedName("rocket_id")
    val rocketId: String,
    @SerializedName("rocket_name")
    val rocketName: String,
    @SerializedName("rocket_type")
    val rocketType: String,
    @SerializedName("second_stage")
    val secondStage: SecondStage,
    @SerializedName("stages")
    val stages: Int,
    @SerializedName("success_rate_pct")
    val successRatePct: Int,
    @SerializedName("wikipedia")
    val wikipedia: String
): Serializable