package com.tranhuuphuc.kotlinkoincoroutinemvvm.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by TranHuuPhuc on 3/25/19.
 */
@Parcelize
class SpokenLanguage : Parcelable {
    @SerializedName("iso_639_1")
    var iso6391: String? = null
    @SerializedName("name")
    var name: String? = null
}
