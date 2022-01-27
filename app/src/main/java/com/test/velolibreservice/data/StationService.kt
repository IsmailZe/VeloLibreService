package com.test.velolibreservice.data

import javax.inject.Inject

class StationService @Inject constructor(private val stationApi: StationApi){

    suspend fun getStations() = stationApi.getStations(API_KEY)

    companion object{
        const val API_KEY = "698ab49d732cd0cbaba97f6928b16f7de3ee004b"
    }
}