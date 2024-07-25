package com.rappi.dynamiclist.proxy.data.model

import com.rappi.dynamiclist.proxy.data.model.home.SimpleComponent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DynamicListContentResponse(@SerialName("data") val data: DynamicListDataContentResponse)

@Serializable
data class DynamicListDataContentResponse(
    @SerialName("context") val context: String = "",
    @SerialName("headers") val headers: List<DynamicListComponentResponse> = listOf(),
    @SerialName("components") val components: List<DynamicListComponentResponse> = listOf(),
    @SerialName("footers") val footers: List<DynamicListComponentResponse> = listOf(),
    @SerialName("in_apps") val inApps: List<DynamicListComponentResponse> = listOf(),
)

@Serializable
data class DynamicListComponentResponse(
    @SerialName("name") val name: String?,
    @SerialName("index") val index: Int,
    @SerialName("render") val render: String,
    @SerialName("resolver") val resolver: String?,
    @SerialName("resource") val resource: SimpleComponent?,
    @SerialName("next_context") val nextContext: String = "",
    @SerialName("pagination_resolver") val paginationResolver: String = "",
    @SerialName("state") val state: HashMap<String, String>? = null,
)