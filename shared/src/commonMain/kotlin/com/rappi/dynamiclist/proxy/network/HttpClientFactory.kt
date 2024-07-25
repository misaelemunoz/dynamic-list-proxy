package com.rappi.dynamiclist.proxy.network

import io.ktor.client.HttpClient

expect val httpClient: HttpClient

internal const val DEFAULT_TIMEOUT: Long = 60_000