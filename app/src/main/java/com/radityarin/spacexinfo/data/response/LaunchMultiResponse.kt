package com.radityarin.spacexinfo.data.response

import com.radityarin.spacexinfo.data.model.launches.Launches

data class LaunchMultiResponse(
    val data: MutableList<Launches>
)