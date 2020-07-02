package com.radityarin.spacexinfo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.radityarin.spacexinfo.R
import com.radityarin.spacexinfo.data.model.launches.LaunchesItem
import com.radityarin.spacexinfo.data.model.rockets.RocketsItem
import com.radityarin.spacexinfo.databinding.ItemLaunchesBinding
import com.radityarin.spacexinfo.databinding.ItemRocketsBinding

class RocketAdapter(val itemOnClickListener: (item: RocketsItem) -> Unit) : RecyclerView.Adapter<RocketAdapter.ViewHolder>() {

    private val items = mutableListOf<RocketsItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRocketsBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[holder.adapterPosition])
    }

    fun addAll(data: List<RocketsItem>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder (private val binding: ItemRocketsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: RocketsItem){
            with(binding){
                root.context?.let {
                    Glide.with(binding.root)
                        .load(item.flickrImages[0])
                        .placeholder(R.drawable.missionpatchplaceholder)
                        .into(ivRocketPhoto)
                    tvRocketName.text = item.rocketName
                    tvRocketDescription.text = item.description
                }

                root.setOnClickListener {
                    itemOnClickListener(item)
                }
            }

        }

    }

}