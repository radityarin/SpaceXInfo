package com.radityarin.spacexinfo.data.model.launches


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

data class FirstStage(
    @SerializedName("cores")
    val cores: List<Core>
): Serializable