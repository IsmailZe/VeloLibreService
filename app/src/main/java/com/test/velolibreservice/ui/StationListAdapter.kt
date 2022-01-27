package com.test.velolibreservice.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.velolibreservice.databinding.StationItemBinding
import com.test.velolibreservice.data.models.Station


class StationListAdapter(val onClick: (station: Station)->Unit) :
    ListAdapter<Station, StationListAdapter.StationViewHolder>(DiffCallback()) {


    inner class StationViewHolder(val binding: StationItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(station: Station) {
            binding.tvName.text = station.name
            binding.tvAddress.text = station.address
            binding.tvStatus.text = station.status
            binding.container.setOnClickListener {
                onClick(station)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StationViewHolder =
        StationViewHolder(
            StationItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: StationViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }

    class DiffCallback : DiffUtil.ItemCallback<Station>() {
        override fun areItemsTheSame(oldItem: Station, newItem: Station) = oldItem == newItem
        override fun areContentsTheSame(oldItem: Station, newItem: Station) = oldItem == newItem
    }
}
