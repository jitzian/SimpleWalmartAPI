package test.platzi.com.raian.com.org.simpleplatzi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ImageEntity {

    @SerializedName("thumbnailImage")
    @Expose
    var thumbnailImage: String? = null
    @SerializedName("mediumImage")
    @Expose
    var mediumImage: String? = null
    @SerializedName("largeImage")
    @Expose
    var largeImage: String? = null
    @SerializedName("entityType")
    @Expose
    var entityType: String? = null

}
