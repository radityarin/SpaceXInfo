package com.radityarin.spacexinfo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.radityarin.spacexinfo.data.model.historical.History
import com.radityarin.spacexinfo.databinding.ItemHistoricalEventsBinding

class HistoricalAdapter(val itemOnClickListener: (item: History) -> Unit) :
    RecyclerView.Adapter<HistoricalAdapter.ViewHolder>() {
    private val items = mutableListOf<History>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HistoricalAdapter.ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoricalEventsBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount() = items.size


    override fun onBindViewHolder(holder: HistoricalAdapter.ViewHolder, position: Int) {
        holder.bind(items[holder.adapterPosition])
    }

    inner class ViewHolder(private val binding: ItemHistoricalEventsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: History) {
            with(binding) {
                root.context?.let {
                    tvHistoryTitle.text = item.title
                    tvHistoryDate.text = item.eventDateUtc
                    tvHistoryDetails.text = item.details
                }

                root.setOnClickListener {
                    itemOnClickListener(item)
                }
            }

        }
    }

    fun addAll(data: List<History>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }
}