package com.radityarin.spacexinfo.data.source.remote

class AppRemoteSource(private val api: Api) {
    fun allLaunch() = api.getAllLaunch()

    fun upcomingLaunch() = api.getUpcomingLaunch()

    fun pastLaunch() = api.getPastLaunch()

    fun latestLaunch() = api.getLatestLaunch()

    fun nextLaunch() = api.getNextLaunch()

    fun historicalEvents() = api.getHistoricalEvents()

    fun allRockets() = api.getAllRockets()

    fun aboutCompany() = api.getAboutCompany()

}