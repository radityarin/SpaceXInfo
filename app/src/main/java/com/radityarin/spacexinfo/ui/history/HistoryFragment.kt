package com.radityarin.spacexinfo.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.radityarin.spacexinfo.R
import com.radityarin.spacexinfo.data.model.historical.History
import com.radityarin.spacexinfo.databinding.FragmentHistoryBinding
import com.radityarin.spacexinfo.ui.adapter.HistoricalAdapter
import kotlinx.android.synthetic.main.fragment_missions.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryFragment : Fragment() {

    private val viewModel by viewModel<HistoryFragmentViewModel>()
    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val historicalAdapter = setAdapter()

        initView()
        observe(historicalAdapter)
    }

    private fun initView() {
        viewModel.loadCacheHistoricalEvents()
        with(binding) {
            swipeRefresh.setOnRefreshListener { viewModel.getHistoricalEvents() }
        }
    }

    private fun setAdapter(): HistoricalAdapter {
        val historicalAdapter = HistoricalAdapter(::moveToDetailPage)
        binding.rvHistoricalEvents.apply {
            layoutManager = LinearLayoutManager(this@HistoryFragment.context)
            val myDivider =
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            myDivider.setDrawable(ContextCompat.getDrawable(context, R.drawable.divider_color)!!)
            addItemDecoration(myDivider)
            addItemDecoration(myDivider)
            adapter = historicalAdapter
        }
        return historicalAdapter
    }

    private fun observe(adapter: HistoricalAdapter) {
        viewModel.historyListItems.observe(viewLifecycleOwner, Observer {
            adapter.addAll(it)
            shimmer_view_container.stopShimmerAnimation()
            shimmer_view_container.visibility = View.GONE
            binding.swipeRefresh.isRefreshing = false
        })
    }

    private fun moveToDetailPage(item: History) {
        //TODO
    }
}