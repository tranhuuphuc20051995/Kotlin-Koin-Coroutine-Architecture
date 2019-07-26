package com.tranhuuphuc.kotlinkoincoroutinemvvm.utils

import android.content.Context

class NetworkManager(private val applicationContext: Context) {

    val isConnected: Boolean
        get() = applicationContext.isConnected

}