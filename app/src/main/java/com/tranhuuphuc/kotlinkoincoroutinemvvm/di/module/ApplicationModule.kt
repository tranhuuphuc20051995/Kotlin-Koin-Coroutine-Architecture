package com.tranhuuphuc.kotlinkoincoroutinemvvm.di.module

import androidx.room.Room
import com.google.gson.GsonBuilder
import com.tranhuuphuc.kotlinkoincoroutinemvvm.databases.AppDatabase
import com.tranhuuphuc.kotlinkoincoroutinemvvm.databases.repositories.RepositoryManager
import com.tranhuuphuc.kotlinkoincoroutinemvvm.managers.movie.MovieManager
import com.tranhuuphuc.kotlinkoincoroutinemvvm.managers.movie.MovieManagerImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Created by TranHuuPhuc on 2019-07-27.
 */
val applicationModule = module {
    single { GsonBuilder().create() }

    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "koin-db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    single {
        RepositoryManager(get())
    }

    single<MovieManager> {
        MovieManagerImpl(get(), get(), get(), get())
    }
}