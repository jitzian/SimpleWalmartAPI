package test.platzi.com.raian.com.org.simpleplatzi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Item {

    @SerializedName("itemId")
    @Expose
    var itemId: Int = 0
    @SerializedName("parentItemId")
    @Expose
    var parentItemId: Int = 0
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("msrp")
    @Expose
    var msrp: Double = 0.toDouble()
    @SerializedName("salePrice")
    @Expose
    var salePrice: Double = 0.toDouble()
    @SerializedName("upc")
    @Expose
    var upc: String? = null
    @SerializedName("categoryPath")
    @Expose
    var categoryPath: String? = null
    @SerializedName("shortDescription")
    @Expose
    var shortDescription: String? = null
    @SerializedName("longDescription")
    @Expose
    var longDescription: String? = null
    @SerializedName("thumbnailImage")
    @Expose
    var thumbnailImage: String? = null
    @SerializedName("mediumImage")
    @Expose
    var mediumImage: String? = null
    @SerializedName("largeImage")
    @Expose
    var largeImage: String? = null
    @SerializedName("productTrackingUrl")
    @Expose
    var productTrackingUrl: String? = null
    @SerializedName("standardShipRate")
    @Expose
    var standardShipRate: Double = 0.toDouble()
    @SerializedName("marketplace")
    @Expose
    var isMarketplace: Boolean = false
    @SerializedName("modelNumber")
    @Expose
    var modelNumber: String? = null
    @SerializedName("productUrl")
    @Expose
    var productUrl: String? = null
    @SerializedName("customerRating")
    @Expose
    var customerRating: String? = null
    @SerializedName("numReviews")
    @Expose
    var numReviews: Int = 0
    @SerializedName("customerRatingImage")
    @Expose
    var customerRatingImage: String? = null
    @SerializedName("categoryNode")
    @Expose
    var categoryNode: String? = null
    @SerializedName("bundle")
    @Expose
    var isBundle: Boolean = false
    @SerializedName("stock")
    @Expose
    var stock: String? = null
    @SerializedName("addToCartUrl")
    @Expose
    var addToCartUrl: String? = null
    @SerializedName("affiliateAddToCartUrl")
    @Expose
    var affiliateAddToCartUrl: String? = null
    @SerializedName("imageEntities")
    @Expose
    var imageEntities: List<ImageEntity>? = null
    @SerializedName("offerType")
    @Expose
    var offerType: String? = null
    @SerializedName("isTwoDayShippingEligible")
    @Expose
    var isIsTwoDayShippingEligible: Boolean = false
    @SerializedName("availableOnline")
    @Expose
    var isAvailableOnline: Boolean = false

}
