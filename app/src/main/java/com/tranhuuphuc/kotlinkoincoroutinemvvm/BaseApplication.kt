package com.tranhuuphuc.kotlinkoincoroutinemvvm

import android.app.Application
import com.tranhuuphuc.kotlinkoincoroutinemvvm.di.module.applicationModule
import com.tranhuuphuc.kotlinkoincoroutinemvvm.di.module.networkModule
import com.tranhuuphuc.kotlinkoincoroutinemvvm.di.module.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by TranHuuPhuc on 2019-07-27.
 */
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@BaseApplication)
            modules(listOf(viewModelsModule, networkModule, applicationModule))
        }
    }
}