@file:Suppress("SENSELESS_COMPARISON")

package com.radityarin.spacexinfo.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.radityarin.spacexinfo.R
import com.radityarin.spacexinfo.data.model.launches.Launch
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
        val itemLaunches = intent.getSerializableExtra(LAUNCH_EXTRA) as Launch
        with(binding) {
            supportActionBar?.title = itemLaunches.missionName
            Glide.with(binding.root)
                .load(itemLaunches.links.missionPatch)
                .placeholder(R.drawable.mission_patch_placeholder)
                .into(ivMissionPatch)
            tvTitle.text = itemLaunches.missionName
            tvPayload.text = itemLaunches.rocket.secondStage.payloads[0].payloadId
            tvRocket.text = itemLaunches.rocket.rocketName
            tvDate.text = itemLaunches.launchDateLocal
            tvLaunchSite.text = itemLaunches.launchSite.siteNameLong
            tvDescription.text = itemLaunches.details

            btnWatchVideo.setOnClickListener {
                if (itemLaunches.links.videoLink != null) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(itemLaunches.links.videoLink.toString())
                        )
                    )
                } else {
                    Toast.makeText(
                        this@DetailActivity,
                        getString(R.string.no_video_warning),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}