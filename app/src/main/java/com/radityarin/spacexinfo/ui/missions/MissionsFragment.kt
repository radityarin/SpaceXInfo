package com.radityarin.spacexinfo.ui.missions

import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.radityarin.spacexinfo.R
import com.radityarin.spacexinfo.data.model.launches.LaunchesItem
import com.radityarin.spacexinfo.databinding.FragmentMissionsBinding
import com.radityarin.spacexinfo.ui.adapter.LaunchAdapter
import com.radityarin.spacexinfo.ui.detail.DetailActivity
import com.radityarin.spacexinfo.util.Constant
import io.reactivex.plugins.RxJavaPlugins
import kotlinx.android.synthetic.main.fragment_missions.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MissionsFragment : Fragment() {

    private val viewModel by viewModel<MissionsFragmentViewModel>()
    private var _binding: FragmentMissionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMissionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val launchAdapter = setAdapter()

        initView()
        observe(launchAdapter)
    }


    private fun initView() {
        btn_upcoming_launch.isSelected = true
        btn_upcoming_launch.setTextColor(Color.WHITE)
        with(binding) {
            shimmerViewContainer.startShimmerAnimation()
            swipeRefresh.setOnRefreshListener {
                viewModel.getUpcomingLaunch()
                viewModel.getAllLaunches()
            }
            btnPastLaunch.setOnClickListener {
                shimmerViewContainer.startShimmerAnimation()
                showPastLaunch()
                btnPastLaunch.setTextColor(Color.WHITE)
                btnUpcomingLaunch.setTextColor(resources.getColor(R.color.colorAccent))
                btnUpcomingLaunch.isSelected = false
                btnPastLaunch.isSelected = true
                viewModel.getPastLaunch()
            }
            btnUpcomingLaunch.setOnClickListener {
                shimmerViewContainer.startShimmerAnimation()
                showUpcomingLaunch()
                btnUpcomingLaunch.setTextColor(Color.WHITE)
                btnPastLaunch.setTextColor(resources.getColor(R.color.colorAccent))
                btnUpcomingLaunch.isSelected = true
                btnPastLaunch.isSelected = false
            }
        }
        showUpcomingLaunch()
        viewModel.getUpcomingLaunch()
    }

    private fun setAdapter(): LaunchAdapter {
        val launchAdapter = LaunchAdapter(::moveToDetailPage)
        binding.rvUpcomingLaunches.apply {
            layoutManager = LinearLayoutManager(this@MissionsFragment.context)
            addItemDecoration(
                DividerItemDecoration(
                    this@MissionsFragment.context,
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter = launchAdapter
        }
        binding.rvPastLaunches.apply {
            layoutManager = LinearLayoutManager(this@MissionsFragment.context)
            addItemDecoration(
                DividerItemDecoration(
                    this@MissionsFragment.context,
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter = launchAdapter
        }
        return launchAdapter
    }

    private fun showPastLaunch() {
        rv_upcoming_launches.visibility = View.GONE
        rv_past_launches.visibility = View.VISIBLE
    }

    private fun showUpcomingLaunch() {
        rv_past_launches.visibility = View.GONE
        rv_upcoming_launches.visibility = View.VISIBLE
    }

    private fun observe(adapter: LaunchAdapter) {
        RxJavaPlugins.setErrorHandler {
            Log.d(TAG, it.message.toString())
            shimmer_view_container.stopShimmerAnimation()
            shimmer_view_container.visibility = View.GONE
        }
        viewModel.upcomingLaunch.observe(viewLifecycleOwner, Observer {
            adapter.addAll(it)
            shimmer_view_container.stopShimmerAnimation()
            shimmer_view_container.visibility = View.GONE
            binding.swipeRefresh.isRefreshing = false
        })
        viewModel.pastLaunch.observe(viewLifecycleOwner, Observer {
            adapter.addAll(it)
            shimmer_view_container.stopShimmerAnimation()
            shimmer_view_container.visibility = View.GONE
            binding.swipeRefresh.isRefreshing = false
        })
    }

    private fun moveToDetailPage(item: LaunchesItem) {
        binding.root.context.startActivity(
            Intent(
                binding.root.context,
                DetailActivity::class.java
            ).apply {
                putExtra(Constant.LAUNCH_EXTRA, item)
            })
    }

}