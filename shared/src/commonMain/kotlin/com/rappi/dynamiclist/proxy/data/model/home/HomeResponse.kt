package com.rappi.dynamiclist.proxy.data.model.home

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeResponse(
    @SerialName("header") val header: ArrayList<Component>,
    @SerialName("body") val body: ArrayList<Component>,
    @SerialName("footer") val footer: ArrayList<Component>,
    @SerialName("inapps") val inApps: ArrayList<Component>?
)

@Serializable
data class Component(
    @SerialName("id") val id: String?,
    @SerialName("index") val index: Int?,
    @SerialName("owner") val owner: String?,
    @SerialName("title") val title: String?,
    @SerialName("content") val content: ArrayList<Content>?,
    @SerialName("style") val style: Style?,
    @SerialName("action") val action: ContentAction?,
    @SerialName("header") val header: Content?,
    @SerialName("body") val body: Content?,
    @SerialName("footer") val footer: Content?,
    @SerialName("analytics") val analytics: ComponentAnalytics?,
    @SerialName("layout") val layout: ContentLayout? = null,
    @SerialName("configuration") val configuration: ContentConfiguration? = null,
    @SerialName("image") val image: String? = null,
    @SerialName("resources") val resources: List<ContentResources>? = null
)

@Serializable
data class SimpleComponent(
    @SerialName("content") val content: ArrayList<Content>?,
    @SerialName("style") val style: Style?,
    @SerialName("action") val action: ContentAction?,
    @SerialName("header") val header: Content?,
    @SerialName("body") val body: Content?,
    @SerialName("footer") val footer: Content?,
    @SerialName("analytics") val analytics: ComponentAnalytics?,
    @SerialName("layout") val layout: ContentLayout? = null,
    @SerialName("configuration") val configuration: ContentConfiguration? = null,
    @SerialName("image") val image: String? = null,
    @SerialName("resources") val resources: List<ContentResources>? = null
)

@Serializable
data class ComponentAnalytics(
    @SerialName("vertical_group")
    val verticalGroup: String?,
    @SerialName("vertical_sub_group")
    var verticalSubGroup: String?,
    @SerialName("source")
    var source: String?,
    @SerialName("type")
    val type: String?,
    @SerialName("triggered_by")
    val triggeredBy: String?,
    @SerialName("campaign_id")
    var campaignId: String?,
    @SerialName("style")
    val style: String?,
    @SerialName("content_id")
    var contentIdList: String?,
    @SerialName("content_type")
    var contentType: String?,
    @SerialName("ads_id")
    val adsId: String?,
    @SerialName("ads_source")
    val adsSource: String?,
    @SerialName("ads_source_type")
    val adsSourceType: String?,
    @SerialName("ads_placements")
    val adsPlacements: String?,
    @SerialName("ads_tag_id")
    val adsTagId: Int?,
    @SerialName("brand_id")
    val adsBrandId: String?,
    @SerialName("microzone_id")
    val adsMicroZoneId: Long?,
    @SerialName("offer_tag")
    val offerTag: Boolean?,
    @SerialName("deeplink")
    val deeplink: String?,
    @SerialName("store_id")
    val storeId: String?,
    @SerialName("product_id")
    val productId: String?,
    @SerialName("event_token_id")
    val tokenId: String?
)

@Serializable
data class Style(
    @SerialName("id")
    val id: String?,
    @SerialName("type")
    val type: String?,
    @SerialName("columns")
    val columns: Int?,
    @SerialName("pages")
    val pages: Int?,
    @SerialName("rows")
    val rows: Int?,
    @SerialName("paginated")
    val paginated: Boolean?,
    @SerialName("vertical")
    val vertical: String?,
    @SerialName("title")
    val title: Title?,
    @SerialName("background")
    val background: Background?,
    @SerialName("subtitle")
    val subtitle: SubTitle?,
    @SerialName("modal_title")
    val modalTitle: ModalTitle?,
    @SerialName("margin")
    val margin: Margin?,
    @SerialName("start_background_color")
    val startBackgroundColor: String?,
    @SerialName("end_background_color")
    val endBackgroundColor: String?,
    @SerialName("show_stores_logo")
    val showStoresLogo: Boolean? = false,
)

@Serializable
data class Title(
    @SerialName("value")
    val value: String?,
    @SerialName("color")
    val color: String?
)

@Serializable
data class SubTitle(
    @SerialName("value")
    val value: String?,
    @SerialName("color")
    val color: String?
)

@Serializable
data class ModalTitle(
    @SerialName("value") val value: String?,
    @SerialName("color") val color: String?
)

@Serializable
data class Background(
    @SerialName("colors") val colors: ArrayList<String>?
)

@Serializable
data class Margin(
    @SerialName("top")
    val top: Int?,
    @SerialName("bottom")
    val bottom: Int?,
    @SerialName("left")
    val left: Int?,
    @SerialName("Right")
    val right: Int?
)

@Serializable
data class Content(
    @SerialName("id")
    val id: String? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("resources")
    val resources: List<ContentResources>? = null,
    @SerialName("action")
    val action: ContentAction? = null,
    @SerialName("content")
    val content: ArrayList<Content>? = null,
    @SerialName("layout")
    val layout: ContentLayout? = null,
    @SerialName("configuration")
    val configuration: ContentConfiguration? = null,
    @SerialName("analytics")
    val analytics: ComponentAnalytics? = null,
    @SerialName("owner")
    val owner: String? = null,
    @SerialName("image")
    val image: String? = null,
    @SerialName("style")
    val style: Style? = null
)

@Serializable
data class ContentResources(
    @SerialName("value")
    val value: String? = null,
    @SerialName("type")
    val type: String? = null,
    @SerialName("style")
    val style: String? = null,
    @SerialName("main")
    val main: Boolean? = false
)

@Serializable
data class ContentLayout(
    @SerialName("price")
    val realPrice: String? = null,
    @SerialName("price_with_discount")
    val priceWithDiscount: String? = null,
    @SerialName("presentation")
    val productDetail: String? = null,
    @SerialName("offer_tag")
    val offerTag: String? = null,
    @SerialName("store_title")
    val storeTitle: String? = null,
    @SerialName("store_icon")
    val storeIcon: String? = null,
    @SerialName("offer_title_font_color")
    val offerTitleFontColor: String? = null,
    @SerialName("ad_icon")
    val adsUrlImage: String? = null,
    @SerialName("offer_is_prime_exclusive")
    val isPrimeExclusive: Boolean? = false,
    @SerialName("delivery_price_icon")
    val deliveryPriceIcon: String? = null,
    @SerialName("top_icon")
    val topIcon: String? = null,
    @SerialName("image")
    val mainImage: String? = null,
    @SerialName("background")
    val background: String? = null,
    @SerialName("store_logo")
    val storeLogo: String? = null,
    @SerialName("delivery_price_title_font_color")
    val deliveryPriceColor: String? = null,
    @SerialName("rating")
    val rating: String? = null,
    @SerialName("delivery_price_title")
    val deliveryPriceTitle: String? = null,
    @SerialName("eta")
    val eta: String? = null,
    @SerialName("market_category_tag")
    val marketCategoryTag: String? = null,
    @SerialName("offer_title")
    val offerTitle: String? = null,
    @SerialName("font_color")
    val font: String? = null,
    @SerialName("title_font_color")
    val titleFontColor: String? = null,
    @SerialName("position")
    val position: String? = null,
    @SerialName("icon")
    val icon: String? = null,
    @SerialName("style")
    val style: String? = null,
    @SerialName("type")
    val type: String? = null,
    @SerialName("enabled")
    val isAvailable: Boolean? = false,
    @SerialName("locked")
    val isLocked: Boolean? = false,
    @SerialName("start_background_color")
    val startBackground: String? = null,
    @SerialName("end_background_color")
    val endBackground: String? = null,
    @SerialName("is_main_title")
    val isMainTitle: Boolean? = false,
    @SerialName("title")
    val title: String? = null,
    @SerialName("color")
    val color: String? = null,
    @SerialName("store_style")
    val storeStyle: String? = null,
    @SerialName("size")
    val size: Float? = null,
    @SerialName("margin_left")
    val marginStart: Int? = null,
    @SerialName("margin_top")
    val marginTop: Int? = null,
    @SerialName("margin_right")
    val marginEnd: Int? = null,
    @SerialName("margin_bottom")
    val marginBottom: Int? = null,
    @SerialName("category_tag")
    val categoryTag: String? = null,
    @SerialName("distance")
    val distance: String? = null
)

@Serializable
data class ContentConfiguration(
    @SerialName("ids")
    val ids: List<String>? = null,
    @SerialName("pagination_data")
    val paginationData: String? = null,
    @SerialName("ads_tag_id")
    val adsTagId: Int? = null,
    @SerialName("source")
    val adsSource: String? = null,
    @SerialName("microzone_id")
    val adsMicroZoneId: Long? = null,
    @SerialName("ads_source_type")
    val adsSourceType: String? = null,
    @SerialName("ads_id")
    val adsId: String? = null,
    @SerialName("starts_at")
    val startsAt: String? = null,
    @SerialName("ends_at")
    val endsAt: String? = null,
    @SerialName("ad_token")
    val adToken: String? = null,
    @SerialName("brand_id")
    val brandId: Int? = null,
    @SerialName("store_id")
    val storeId: String? = null,
    @SerialName("brand_name")
    val brandName: String? = null,
    @SerialName("auto_swipe")
    val autoSwipe: Boolean? = false,
    @SerialName("auto_swipe_interval")
    val autoSwipeInterval: Int? = 0
)

@Serializable
data class ContentAction(
    @SerialName("type")
    val type: String,
    @SerialName("data")
    val data: ContentDataAction? = null,
    @SerialName("automatic")
    val automatic: Boolean = false,
    @SerialName("id")
    val id: String? = null
)

@Serializable
data class ContentDataAction(
    @SerialName("id")
    val id: String? = null,
    @SerialName("index")
    val index: String? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("include_widget")
    val includeWidget: Boolean? = false,
    @SerialName("label")
    val label: ContentDataLabelAction? = null,
    @SerialName("style")
    val style: ContentDataStyle? = null,
    @SerialName("header")
    val header: ContentDataHeader? = null,
    @SerialName("content")
    val content: ArrayList<Content>? = null,
    @SerialName("inapps")
    val inapps: ArrayList<Component>? = null,
    @SerialName("deeplink")
    var deeplink: Map<String, String>? = null,
    @SerialName("action_label_font_color")
    val actionLabelFontColor: String? = null,
    @SerialName("action_label")
    val actionLabel: String? = null,
    @SerialName("widget_groups_body")
    val widgetGroupsBody: ContentWidgetGroups? = null
)

@Serializable
data class ContentDataLabelAction(
    @SerialName("value") val value: String? = null,
    @SerialName("style") val style: String? = null
)

@Serializable
data class ContentDataStyle(
    @SerialName("id") val value: String? = null,
    @SerialName("style") val style: String? = null
)

@Serializable
data class ContentDataHeader(
    @SerialName("title") val title: String? = null,
    @SerialName("style") val style: ContentDataStyle? = null
)

@Serializable
data class ContentWidgetGroups(
    @SerialName("brand_id") val brandId: String? = null,
    @SerialName("store_id") val storeId: String? = null,
    @SerialName("store_type") val storeType: String? = null,
    @SerialName("group") val group: String? = null
)