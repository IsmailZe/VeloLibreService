package com.test.velolibreservice.data

import com.test.velolibreservice.data.models.StationSchema
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface StationApi {

    @Headers("accept: application/json")
    @GET("stations")
    suspend fun getStations(
        @Query("apiKey") apiKey: String
    ): List<StationSchema>
}