package com.radityarin.spacexinfo.ui.missions

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.radityarin.spacexinfo.R
import com.radityarin.spacexinfo.data.model.launches.LaunchesItem
import com.radityarin.spacexinfo.databinding.FragmentMissionsBinding
import com.radityarin.spacexinfo.ui.adapter.LaunchAdapter
import com.radityarin.spacexinfo.ui.detail.DetailActivity
import com.radityarin.spacexinfo.util.Constant
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

        val launchAdapter = setAdapter(binding.rvLaunches)

        initView()
        observe(launchAdapter)
    }

    private fun setAdapter(launches: RecyclerView): LaunchAdapter {
        val launchAdapter = LaunchAdapter(::moveToDetailPage)
        launches.apply {
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


    private fun initView() {
        with(binding) {
            shimmerViewContainer.startShimmerAnimation()
            swipeRefresh.setOnRefreshListener {
                if (btnPastLaunch.isSelected) {
                    viewModel.getPastLaunch()
                } else {
                    viewModel.getUpcomingLaunch()
                }
            }
            btnPastLaunch.setOnClickListener {
                showPastLaunch()
                viewModel.getPastLaunch()
            }
            btnUpcomingLaunch.setOnClickListener {
                showUpcomingLaunch()
                viewModel.getUpcomingLaunch()
            }
        }
        showUpcomingLaunch()
        viewModel.getUpcomingLaunch()
    }

    private fun showPastLaunch() {
        shimmer_view_container.visibility = View.VISIBLE
        rv_launches.visibility = View.GONE
        shimmer_view_container.startShimmerAnimation()
        btn_past_launch.setTextColor(Color.WHITE)
        btn_upcoming_launch.setTextColor(resources.getColor(R.color.colorPrimaryDark))
        btn_past_launch.isSelected = true
        btn_upcoming_launch.isSelected = false
    }

    private fun showUpcomingLaunch() {
        shimmer_view_container.visibility = View.VISIBLE
        rv_launches.visibility = View.GONE
        shimmer_view_container.startShimmerAnimation()
        btn_upcoming_launch.setTextColor(Color.WHITE)
        btn_past_launch.setTextColor(resources.getColor(R.color.colorPrimaryDark))
        btn_upcoming_launch.isSelected = true
        btn_past_launch.isSelected = false
    }

    private fun observe(launchAdapter: LaunchAdapter) {
        viewModel.upcomingLaunch.observe(viewLifecycleOwner, Observer {
            launchAdapter.addAll(it)
            shimmer_view_container.stopShimmerAnimation()
            shimmer_view_container.visibility = View.GONE
            binding.swipeRefresh.isRefreshing = false
            rv_launches.visibility = View.VISIBLE
        })
        viewModel.pastLaunch.observe(viewLifecycleOwner, Observer {
            launchAdapter.addAll(it)
            shimmer_view_container.stopShimmerAnimation()
            shimmer_view_container.visibility = View.GONE
            binding.swipeRefresh.isRefreshing = false
            rv_launches.visibility = View.VISIBLE
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