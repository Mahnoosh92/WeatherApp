package com.mahdavi.weatherapp.ui.dashboard.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mahdavi.weatherapp.data.model.local.cities.City
import com.mahdavi.weatherapp.databinding.CityItemBinding
import com.mahdavi.weatherapp.ui.dashboard.home.click.ClickListener

class CityAdapter(private val clickListener: ClickListener) : ListAdapter<City, RecyclerView.ViewHolder>(PersonDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = CityItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CityViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CityViewHolder).bind(getItem(position))
    }

    inner class CityViewHolder(private val binding: CityItemBinding, private val clickListener: ClickListener) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(city: City) {
            binding.apply {
                root.setOnClickListener{
                    clickListener.onClick(city)
                }
                country.text = city.country
                latitude.text = city.latitude.toString()
                longitude.text = city.longitude.toString()
            }
        }
    }
}

class PersonDiffUtil : DiffUtil.ItemCallback<City>() {
    override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
        return oldItem.key == newItem.key
    }

    override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
        return oldItem == newItem
    }
}