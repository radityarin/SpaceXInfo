package com.radityarin.spacexinfo.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.radityarin.spacexinfo.data.model.launches.LaunchesItem
import com.radityarin.spacexinfo.databinding.ActivityMainBinding
import com.radityarin.spacexinfo.ui.adapter.LaunchAdapter
import com.radityarin.spacexinfo.ui.detail.DetailActivity
import com.radityarin.spacexinfo.util.Constant.LAUNCH_EXTRA
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainActivityViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val launchAdapter = setAdapter()

        initView()
        observe(launchAdapter)
    }

    private fun setAdapter(): LaunchAdapter {
        val launchAdapter = LaunchAdapter(::moveToDetailPage)
        binding.rvUpcomingLaunches.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter = launchAdapter
        }
        return launchAdapter
    }

    private fun initView() {
        with(binding){
            swipeRefresh.setOnRefreshListener { viewModel.getUpcomingLaunch() }
        }
        viewModel.getUpcomingLaunch()
    }

    private fun observe(adapter: LaunchAdapter) {
        viewModel.upcomingLaunch.observe(this, Observer {
            adapter.addAll(it)
            binding.swipeRefresh.isRefreshing = false
        })
    }

    private fun moveToDetailPage(item: LaunchesItem){
        startActivity(Intent(this, DetailActivity::class.java).apply {
            putExtra(LAUNCH_EXTRA, item)
        })
    }

}