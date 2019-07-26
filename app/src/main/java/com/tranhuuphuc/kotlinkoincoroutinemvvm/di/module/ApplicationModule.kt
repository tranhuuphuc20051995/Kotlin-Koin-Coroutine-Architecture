package com.tranhuuphuc.kotlinkoincoroutinemvvm.di.module

import com.google.gson.GsonBuilder
import com.tranhuuphuc.kotlinkoincoroutinemvvm.repositories.impl.MovieRepository
import org.koin.dsl.module

/**
 * Created by TranHuuPhuc on 2019-07-27.
 */
val applicationModule = module {
    single { GsonBuilder().create() }

    single { MovieRepository(get(), get(), get()) }

}