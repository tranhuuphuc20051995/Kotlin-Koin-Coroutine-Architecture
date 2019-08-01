package com.tranhuuphuc.kotlinkoincoroutinemvvm.managers.network

import android.content.Context
import com.tranhuuphuc.kotlinkoincoroutinemvvm.utils.isConnected

class NetworkManager(private val applicationContext: Context) {

    val isConnected: Boolean
        get() = applicationContext.isConnected

}