package com.tranhuuphuc.kotlinkoincoroutinemvvm.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by TranHuuPhuc on 3/25/19.
 */
@Parcelize
class ProductionCompany : Parcelable {
    @SerializedName("id")
    var id: Int? = null
    @SerializedName("logo_path")
    var logoPath: String? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("origin_country")
    var originCountry: String? = null
}
