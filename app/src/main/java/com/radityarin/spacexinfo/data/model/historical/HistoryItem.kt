package com.radityarin.spacexinfo.data.model.historical


import com.google.gson.annotations.SerializedName

data class HistoryItem(
    @SerializedName("details")
    val details: String,
    @SerializedName("event_date_unix")
    val eventDateUnix: Int,
    @SerializedName("event_date_utc")
    val eventDateUtc: String,
    @SerializedName("flight_number")
    val flightNumber: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("links")
    val links: Links,
    @SerializedName("title")
    val title: String
)