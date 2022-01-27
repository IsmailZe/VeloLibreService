package com.test.velolibreservice.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Station(
    val address: String? = null,
    val availableBikeStands: Int? = null,
    val availableBikes: Int? = null,
    val banking: Boolean? = null,
    val bikeStands: Int? = null,
    val bonus: Boolean? = null,
    val contractName: String? = null,
    val name: String? = null,
    val number: Int? = null,
    val status: String? = null
): Parcelable