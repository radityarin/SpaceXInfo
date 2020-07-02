package com.radityarin.spacexinfo.ui.missions

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.radityarin.spacexinfo.data.model.launches.LaunchesItem
import com.radityarin.spacexinfo.databinding.FragmentMissionsBinding
import com.radityarin.spacexinfo.ui.adapter.LaunchAdapter
import com.radityarin.spacexinfo.ui.detail.DetailActivity
import com.radityarin.spacexinfo.util.Constant
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
        return launchAdapter
    }

    private fun initView() {
        with(binding) {
            swipeRefresh.setOnRefreshListener { viewModel.getUpcomingLaunch() }
        }
        viewModel.getUpcomingLaunch()
    }

    private fun observe(adapter: LaunchAdapter) {
        viewModel.upcomingLaunch.observe(viewLifecycleOwner, Observer {
            adapter.addAll(it)
            binding.swipeRefresh.isRefreshing = false
        })
    }

    private fun moveToDetailPage(item: LaunchesItem) {
        binding.root.context.startActivity(Intent(binding.root.context, DetailActivity::class.java).apply {
            putExtra(Constant.LAUNCH_EXTRA, item)
        })
    }

}