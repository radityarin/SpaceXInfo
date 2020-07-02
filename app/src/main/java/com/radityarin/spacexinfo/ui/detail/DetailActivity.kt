package com.radityarin.spacexinfo.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.radityarin.spacexinfo.R
import com.radityarin.spacexinfo.data.model.launches.LaunchesItem
import com.radityarin.spacexinfo.databinding.ActivityDetailBinding
import com.radityarin.spacexinfo.util.Constant.LAUNCH_EXTRA

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        val itemLaunches = intent.getSerializableExtra(LAUNCH_EXTRA) as LaunchesItem
        with(binding) {
            Glide.with(binding.root)
                .load(itemLaunches.links.missionPatch)
                .placeholder(R.drawable.missionpatchplaceholder)
                .into(ivMissionPatch)
            tvTitle.text = itemLaunches.missionName
            tvRocket.text = itemLaunches.rocket.rocketName
            tvDate.text = itemLaunches.launchDateLocal
            tvDescription.text = itemLaunches.details
        }
    }
}