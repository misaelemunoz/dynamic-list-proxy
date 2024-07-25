package com.rappi.dynamiclist.proxy.data.mapper

import com.rappi.dynamiclist.proxy.data.model.DynamicListComponentResponse
import com.rappi.dynamiclist.proxy.data.model.DynamicListContentResponse
import com.rappi.dynamiclist.proxy.data.model.DynamicListDataContentResponse
import com.rappi.dynamiclist.proxy.data.model.home.Component
import com.rappi.dynamiclist.proxy.data.model.home.HomeResponse
import com.rappi.dynamiclist.proxy.data.model.home.SimpleComponent

interface DynamicListHomeMapper {
    fun fromHomeResponse(data: HomeResponse): DynamicListContentResponse
}

class DynamicListHomeMapperImpl : DynamicListHomeMapper {

    override fun fromHomeResponse(data: HomeResponse): DynamicListContentResponse {
        val body = toSimpleComponentList(data.body)
        val inApps = toSimpleComponentList(data.inApps.orEmpty())
        val footers = toSimpleComponentList(data.footer)
        val headers = toSimpleComponentList(data.header)

        return DynamicListContentResponse(
            data = DynamicListDataContentResponse(
                context = HOME_CONTEXT,
                headers = headers,
                components = body,
                footers = footers,
                inApps = inApps
            )
        )
    }

    private fun toSimpleComponentList(data: List<Component>): List<DynamicListComponentResponse> {
        return data.map {
            DynamicListComponentResponse(
                name = it.title,
                index = it.index ?: 0,
                render = it.id.orEmpty(),
                resolver = it.owner,
                resource = it.toBaseComponent()
            )
        }
    }

    private fun Component.toBaseComponent(): SimpleComponent {
        return SimpleComponent(
            content = this.content,
            style = this.style,
            action = this.action,
            header = this.header,
            body = this.body,
            footer = this.footer,
            analytics = this.analytics,
            layout = this.layout,
            configuration = this.configuration,
            image = this.image,
            resources = this.resources
        )
    }
}

internal const val HOME_CONTEXT = "rappi_home"