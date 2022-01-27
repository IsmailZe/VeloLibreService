package com.test.velolibreservice.domain

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.test.velolibreservice.data.StationRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class StationsUseCase @Inject constructor(
    private val stationRepository: StationRepository,
    private val dispatcher: CoroutineDispatcher) {
    suspend fun getStations() = withContext(dispatcher) {
        stationRepository.getStations()
    }
}