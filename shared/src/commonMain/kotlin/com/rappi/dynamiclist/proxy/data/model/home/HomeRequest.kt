package com.rappi.dynamiclist.proxy.data.model.home

import kotlinx.serialization.Serializable

@Serializable
data class HomeRequest(
    val cityId: Int,
    val proLevel: Int,
    val latitude: Double,
    val longitude: Double,
)