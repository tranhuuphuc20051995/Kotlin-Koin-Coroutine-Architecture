package com.tranhuuphuc.kotlinkoincoroutinemvvm.features.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tranhuuphuc.kotlinkoincoroutinemvvm.managers.movie.MovieManager
import com.tranhuuphuc.kotlinkoincoroutinemvvm.databases.models.Movie
import com.tranhuuphuc.kotlinkoincoroutinemvvm.databases.models.bases.BaseResponse
import com.tranhuuphuc.kotlinkoincoroutinemvvm.utils.Event
import com.tranhuuphuc.kotlinkoincoroutinemvvm.utils.Resource
import kotlinx.coroutines.launch

/**
 * Created by TranHuuPhuc on 2019-07-27.
 */
class HomeViewModel(private val movieManager: MovieManager) : ViewModel() {
    private val _moviesLiveData = MutableLiveData<Event<Resource<BaseResponse<List<Movie>>>>>()
    val moviesLiveData: LiveData<Event<Resource<BaseResponse<List<Movie>>>>>
        get() = _moviesLiveData

    fun getNowPlaying(pageIndex: Int) = viewModelScope.launch {
        _moviesLiveData.postValue(Event(Resource.Loading))
        val resource = movieManager.getNowPlaying(pageIndex)
        _moviesLiveData.postValue(Event(resource))
    }
}