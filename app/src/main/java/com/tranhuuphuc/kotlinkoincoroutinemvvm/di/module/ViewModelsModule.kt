package com.tranhuuphuc.kotlinkoincoroutinemvvm.di.module

import com.tranhuuphuc.kotlinkoincoroutinemvvm.features.home.HomeViewModel
import com.tranhuuphuc.kotlinkoincoroutinemvvm.features.movie_detail.MovieDetailViewModel
import com.tranhuuphuc.kotlinkoincoroutinemvvm.features.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by TranHuuPhuc on 2019-07-27.
 */
val viewModelsModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { MovieDetailViewModel() }
    viewModel { SearchViewModel() }
}