package com.radityarin.spacexinfo.data.model.launches


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LaunchSite(
    @SerializedName("site_id")
    val siteId: String,
    @SerializedName("site_name")
    val siteName: String,
    @SerializedName("site_name_long")
    val siteNameLong: String
): Serializable