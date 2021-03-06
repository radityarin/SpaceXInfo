package com.radityarin.spacexinfo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.radityarin.spacexinfo.R
import com.radityarin.spacexinfo.data.model.launches.Launch
import com.radityarin.spacexinfo.databinding.ItemLaunchesBinding

class LaunchAdapter(val itemOnClickListener: (item: Launch) -> Unit) : RecyclerView.Adapter<LaunchAdapter.ViewHolder>() {

    private val items = mutableListOf<Launch>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLaunchesBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[holder.adapterPosition])
    }

    fun addAll(data: List<Launch>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder (private val binding: ItemLaunchesBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: Launch){
            with(binding){
                root.context?.let {
                    Glide.with(binding.root)
                        .load(item.links.missionPatch)
                        .placeholder(R.drawable.mission_patch_placeholder)
                        .into(ivMissionPatches)
                    tvLaunchTitle.text = item.missionName
                    tvLaunchRocket.text = item.rocket.rocketName
                    tvLaunchDate.text = item.launchDateLocal
                }

                root.setOnClickListener {
                    itemOnClickListener(item)
                }
            }

        }

    }

}