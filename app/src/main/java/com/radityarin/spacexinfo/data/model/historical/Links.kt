package com.radityarin.spacexinfo.data.model.historical


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("article")
    val article: String,
    @SerializedName("reddit")
    val reddit: String,
    @SerializedName("wikipedia")
    val wikipedia: String
)