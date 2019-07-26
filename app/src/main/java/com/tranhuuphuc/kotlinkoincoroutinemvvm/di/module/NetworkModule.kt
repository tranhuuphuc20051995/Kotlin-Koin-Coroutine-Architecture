package com.tranhuuphuc.kotlinkoincoroutinemvvm.di.module

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.tranhuuphuc.kotlinkoincoroutinemvvm.BuildConfig
import com.tranhuuphuc.kotlinkoincoroutinemvvm.apis.MovieApi
import com.tranhuuphuc.kotlinkoincoroutinemvvm.utils.NetworkManager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber

/**
 * Created by TranHuuPhuc on 2019-07-27.
 */

val networkModule = module {
    single { NetworkManager(androidApplication()) }

    single<OkHttpClient> {
        // Add security interceptor.
        val clientBuilder = OkHttpClient.Builder()
            .addInterceptor { chain ->
                try {
                    val ongoing = chain.request().newBuilder()
                    ongoing.addHeader("Accept", "application/json;versions=1")
                    return@addInterceptor chain.proceed(ongoing.build())
                } catch (e: Throwable) {
                    Timber.w(e)
                }
                return@addInterceptor chain.proceed(chain.request())
            }
        // Add debug interceptors.
        if (BuildConfig.DEBUG) {
            clientBuilder.addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BASIC
            })
            clientBuilder.addNetworkInterceptor(StethoInterceptor())
        }
        clientBuilder.build()
    }

    single<Retrofit> {
        val okHttpClient = get<OkHttpClient>()
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient)
            .build()
    }

    single<MovieApi> {
        val retrofit = get<Retrofit>()
        retrofit.create(MovieApi::class.java)
    }

}