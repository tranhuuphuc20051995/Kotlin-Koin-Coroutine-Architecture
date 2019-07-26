package com.tranhuuphuc.kotlinkoincoroutinemvvm.utils

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.NetworkInfo
import retrofit2.Response
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*

suspend fun <T> safeApiCall(call: suspend () -> Response<T>): Response<T>? = try {
    call()
} catch (e: Throwable) {
    null
}

private val Context.networkInfo: NetworkInfo?
    get() = (getSystemService(CONNECTIVITY_SERVICE) as? ConnectivityManager)?.activeNetworkInfo

val Context.isConnected: Boolean
    get() = networkInfo?.isConnected ?: false