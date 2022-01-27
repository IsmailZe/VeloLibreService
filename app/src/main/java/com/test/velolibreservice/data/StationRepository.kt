package com.test.velolibreservice.data

import com.test.velolibreservice.data.models.StationSchema
import com.test.velolibreservice.data.models.Station
import javax.inject.Inject

class StationRepository @Inject constructor(private val stationService: StationService) {

    suspend fun getStations() = stationService.getStations().map {
        it.toStation()
    }

    companion object {
        fun StationSchema.toStation() = Station(
            address = address,
            availableBikeStands = availableBikeStands,
            availableBikes = availableBikes,
            banking = banking,
            bikeStands = bikeStands,
            bonus = bonus,
            contractName = contractName,
            name = name,
            number = number,
            status = status
        )
    }
}