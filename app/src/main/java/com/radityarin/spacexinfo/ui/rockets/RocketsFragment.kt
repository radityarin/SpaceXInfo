package com.radityarin.spacexinfo.ui.rockets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.radityarin.spacexinfo.data.model.rockets.Rockets
import com.radityarin.spacexinfo.databinding.FragmentRocketsBinding
import com.radityarin.spacexinfo.ui.adapter.RocketAdapter
import kotlinx.android.synthetic.main.fragment_missions.shimmer_view_container
import kotlinx.android.synthetic.main.fragment_rockets.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RocketsFragment : Fragment() {

    private val viewModel by viewModel<RocketFragmentViewModel>()
    private var _binding: FragmentRocketsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRocketsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rocketAdapter = setAdapter(binding.rvRockets)

        initView()
        observe(rocketAdapter)
    }

    private fun setAdapter(launches: RecyclerView): RocketAdapter {
        val rocketAdapter = RocketAdapter(::moveToDetailPage)
        launches.apply {
            layoutManager = LinearLayoutManager(this@RocketsFragment.context)
            addItemDecoration(
                DividerItemDecoration(
                    this@RocketsFragment.context,
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter = rocketAdapter
        }
        return rocketAdapter
    }


    private fun initView() {
        with(binding) {
            shimmerViewContainer.startShimmerAnimation()
            swipeRefresh.setOnRefreshListener {
                viewModel.getAllRockets()
            }
        }
        viewModel.getAllRockets()
    }


    private fun observe(rocketAdapter: RocketAdapter) {
        viewModel.rocketsListItems.observe(viewLifecycleOwner, Observer {
            rocketAdapter.addAll(it)
            shimmer_view_container.stopShimmerAnimation()
            shimmer_view_container.visibility = View.GONE
            binding.swipeRefresh.isRefreshing = false
            rv_rockets.visibility = View.VISIBLE
        })
    }

    private fun moveToDetailPage(item: Rockets) {
        Toast.makeText(context, item.rocketName, Toast.LENGTH_SHORT).show()
    }

}