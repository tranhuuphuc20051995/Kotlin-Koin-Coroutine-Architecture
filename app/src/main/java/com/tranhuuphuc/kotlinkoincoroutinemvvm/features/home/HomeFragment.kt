package com.tranhuuphuc.kotlinkoincoroutinemvvm.features.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.tranhuuphuc.kotlinkoincoroutinemvvm.R
import com.tranhuuphuc.kotlinkoincoroutinemvvm.base.BaseFragment
import com.tranhuuphuc.kotlinkoincoroutinemvvm.databases.models.Movie
import com.tranhuuphuc.kotlinkoincoroutinemvvm.utils.Resource
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by TranHuuPhuc on 2019-07-27.
 */
class HomeFragment : BaseFragment() {
    override fun getLayoutId(): Int = R.layout.fragment_home

    private val viewModel: HomeViewModel by viewModel()
    private val adapter by lazy {
        HomeAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initViewModelObserve()
        viewModel.getNowPlaying(1)
    }

    private fun initViewModelObserve() {
        viewModel.moviesLiveData.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let { resource ->
                when (resource) {
                    is Resource.Loading -> showBlockingProgressDialog()
                    is Resource.RequireLogin -> hideProgressDialog()
                    is Resource.Success -> {
                        hideProgressDialog()
                        adapter.initData(resource.data.results as ArrayList<Movie>?)
                    }
                    is Resource.Error -> {
                        hideProgressDialog()
                        if (!resource.isConnected) {
                            acknowledgeConnectionError()
                        } else {
                            resource.exception.message?.let { it ->
                                acknowledgeError(it)
                            }
                        }
                    }
                }
            }
        })
    }

    @SuppressLint("WrongConstant")
    private fun initAdapter() {
        rvMovie.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvMovie.adapter = adapter
    }
}