package test.platzi.com.raian.com.org.simpleplatzi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResultQueryWalmartProduct {

    @SerializedName("query")
    @Expose
    var query: String? = null
    @SerializedName("sort")
    @Expose
    var sort: String? = null
    @SerializedName("responseGroup")
    @Expose
    var responseGroup: String? = null
    @SerializedName("totalResults")
    @Expose
    var totalResults: Int = 0
    @SerializedName("start")
    @Expose
    var start: Int = 0
    @SerializedName("numItems")
    @Expose
    var numItems: Int = 0
    @SerializedName("items")
    @Expose
    var items: List<Item>? = null
    @SerializedName("facets")
    @Expose
    var facets: List<Any>? = null

}
