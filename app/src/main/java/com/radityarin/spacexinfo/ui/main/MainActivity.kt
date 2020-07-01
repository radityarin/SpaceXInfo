package com.radityarin.spacexinfo.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.radityarin.spacexinfo.data.model.launches.LaunchesItem
import com.radityarin.spacexinfo.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainActivityViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        observe()
    }

    private fun initView() {
        viewModel.getLatestLaunch()
    }

    private fun observe() {
        viewModel.latestLaunch.observe(this, Observer {
            onDataLoaded(it)
        })
    }

    private fun onDataLoaded(data: LaunchesItem) {
        tv_mission_name.text = data.missionName
    }

}