package com.radityarin.spacexinfo.data.model.launches


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("article_link")
    val articleLink: Any,
    @SerializedName("flickr_images")
    val flickrImages: List<Any>,
    @SerializedName("mission_patch")
    val missionPatch: Any,
    @SerializedName("mission_patch_small")
    val missionPatchSmall: Any,
    @SerializedName("presskit")
    val presskit: Any,
    @SerializedName("reddit_campaign")
    val redditCampaign: Any,
    @SerializedName("reddit_launch")
    val redditLaunch: Any,
    @SerializedName("reddit_media")
    val redditMedia: Any,
    @SerializedName("reddit_recovery")
    val redditRecovery: Any,
    @SerializedName("video_link")
    val videoLink: Any,
    @SerializedName("wikipedia")
    val wikipedia: Any,
    @SerializedName("youtube_id")
    val youtubeId: Any
)