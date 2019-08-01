package com.tranhuuphuc.kotlinkoincoroutinemvvm.databases.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by TranHuuPhuc on 3/25/19.
 */
@Parcelize
class ProductionCountry : Parcelable {
    @SerializedName("iso_3166_1")
    var iso31661: String? = null
    @SerializedName("name")
    var name: String? = null

}
