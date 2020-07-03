package com.radityarin.spacexinfo.util

const val DEFAULT_FONT = "fonts/GoogleSans-Regular.ttf"

object Constant {
    const val NETWORK_TIMEOUT = 60L

    const val BASE_URL = "https://api.spacexdata.com/v3/"

    const val LAUNCH_EXTRA = "launch"
}

object CacheKey {
    const val ALL_LAUNCH = "cache_all_launch"
    const val UPCOMING_LAUNCH = "cache_upcoming_launch"
    const val PAST_LAUNCH = "cache_past_launch"
    const val LATEST_LAUNCH = "cache_latest_launch"
    const val HISTORICAL_EVENTS = "cache_historical_events"
    const val ALL_ROCKETS = "cache_all_rockets"
}