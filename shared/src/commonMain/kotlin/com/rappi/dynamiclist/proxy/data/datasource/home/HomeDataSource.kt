package com.rappi.dynamiclist.proxy.data.datasource.home

import com.rappi.dynamiclist.proxy.data.model.home.HomeRequest
import com.rappi.dynamiclist.proxy.data.model.home.HomeResponse
import com.rappi.dynamiclist.proxy.network.httpClient
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter

interface HomeDataSource {

    suspend fun get(
        baseUrl: String,
        request: HomeRequest,
        headers: Map<String, String>
    ): HomeResponse
}

internal class HomeDataSourceImpl(private val client: HttpClient = httpClient): HomeDataSource {

    override suspend fun get(
        baseUrl: String,
        request: HomeRequest,
        headers: Map<String, String>
    ): HomeResponse {
        return client.get("$baseUrl/home/high/") {
            parameter("lat", request.latitude)
            parameter("lng", request.longitude)
            parameter("prime", request.proLevel)
            parameter("city_id", request.cityId)
            headers.forEach { (key, value) ->
                header(key, value)
            }
        }.body()
    }
}