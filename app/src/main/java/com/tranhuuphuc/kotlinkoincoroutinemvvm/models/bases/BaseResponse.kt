package com.tranhuuphuc.kotlinkoincoroutinemvvm.models.bases

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by TranHuuPhuc on 10/26/18.
 */
@Parcelize
class BaseResponse<T> : Parcelable {
    @SerializedName("status_message")
    var statusMessage: String? = null
    var isSuccess: Boolean = false
    @SerializedName("status_code")
    var statusCode: Int = 0
    var results: T? = null
    var page: Int = 0
    var id: Int = 0
    @SerializedName("total_results")
    var totalResults: Int = 0
    @SerializedName("total_pages")
    var totalPages: Int = 0
}
