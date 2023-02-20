package com.mahdavi.weatherapp.ui.dashboard.weather.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mahdavi.weatherapp.data.model.local.cities.CityAutoComplete
import com.mahdavi.weatherapp.databinding.CityAutocompleteItemBinding
import com.mahdavi.weatherapp.ui.dashboard.weather.callback.SearchClickListener

class SearchbarAdapter (private val searchClickListener: SearchClickListener) :
    ListAdapter<CityAutoComplete, RecyclerView.ViewHolder>(CityAutoCompleteDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            CityAutocompleteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ForecastItemViewHolder(binding, searchClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ForecastItemViewHolder).bind(getItem(position))
    }

    inner class ForecastItemViewHolder(
        private val binding: CityAutocompleteItemBinding,
        private val searchClickListener: SearchClickListener
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cityAutoComplete: CityAutoComplete) {
            binding.apply {
                root.setOnClickListener {
                    searchClickListener.onCityClicked(cityAutoComplete)
                }
                cityName.text = cityAutoComplete.localizedName
            }
        }
    }
}

class CityAutoCompleteDiffUtil : DiffUtil.ItemCallback<CityAutoComplete>() {
    override fun areItemsTheSame(oldItem: CityAutoComplete, newItem: CityAutoComplete): Boolean {
        return oldItem.key == newItem.key
    }

    override fun areContentsTheSame(oldItem: CityAutoComplete, newItem: CityAutoComplete): Boolean {
        return oldItem == newItem
    }
}