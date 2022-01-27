package com.test.velolibreservice.data.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import androidx.annotation.Keep

@Keep
@JsonClass(generateAdapter = true)
data class StationSchema(
    @Json(name = "address")
    val address: String? = null,
    @Json(name = "available_bike_stands")
    val availableBikeStands: Int? = null,
    @Json(name = "available_bikes")
    val availableBikes: Int? = null,
    @Json(name = "banking")
    val banking: Boolean? = null,
    @Json(name = "bike_stands")
    val bikeStands: Int? = null,
    @Json(name = "bonus")
    val bonus: Boolean? = null,
    @Json(name = "contract_name")
    val contractName: String? = null,
    @Json(name = "last_update")
    val lastUpdate: Long? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "number")
    val number: Int? = null,
    @Json(name = "position")
    val position: Position? = null,
    @Json(name = "status")
    val status: String? = null
)