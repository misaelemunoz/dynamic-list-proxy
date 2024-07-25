package com.rappi.dynamiclist.proxy.data.repository

import com.rappi.dynamiclist.proxy.data.datasource.home.HomeDataSource
import com.rappi.dynamiclist.proxy.data.datasource.home.HomeDataSourceImpl
import com.rappi.dynamiclist.proxy.data.mapper.DynamicListHomeMapper
import com.rappi.dynamiclist.proxy.data.mapper.DynamicListHomeMapperImpl
import com.rappi.dynamiclist.proxy.data.model.home.HomeRequest
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.encodeToJsonElement

class DynamicListProxyRepositoryImpl(
    private val mapper: DynamicListHomeMapper = DynamicListHomeMapperImpl(),
    private val homeDataSource: HomeDataSource = HomeDataSourceImpl(),
) : DynamicListProxyRepository {

    override suspend fun getHome(
        baseUrl: String,
        request: HomeRequest,
        headers: Map<String, String>
    ): JsonElement {
        val response = homeDataSource.get(baseUrl, request, headers)
        val dynamicListResponse = mapper.fromHomeResponse(response)

        return Json.encodeToJsonElement(dynamicListResponse)
    }
}

interface DynamicListProxyRepository {

    suspend fun getHome(
        baseUrl: String,
        request: HomeRequest,
        headers: Map<String, String>
    ): JsonElement
}