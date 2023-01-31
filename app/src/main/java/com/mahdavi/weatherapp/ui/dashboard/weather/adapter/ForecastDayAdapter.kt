package com.mahdavi.weatherapp.ui.dashboard.weather.adapter

import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mahdavi.weatherapp.data.model.local.forecast.DayForecast
import com.mahdavi.weatherapp.databinding.ForecastItemBinding
import com.mahdavi.weatherapp.ui.dashboard.weather.click.ClickListener
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class ForecastDayAdapter(private val clickListener: ClickListener) :
    ListAdapter<DayForecast, RecyclerView.ViewHolder>(ForecastDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ForecastItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ForecastItemViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ForecastItemViewHolder).bind(getItem(position))
    }

    inner class ForecastItemViewHolder(
        private val binding: ForecastItemBinding,
        private val clickListener: ClickListener
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(dayForecast: DayForecast) {
            binding.apply {
                root.setOnClickListener {
                    clickListener.onClick(dayForecast)
                }
                date.text = dayForecast.date?.split("T")?.get(0)
                maxTemp.text = dayForecast.temperature?.maximum?.value.toString() + dayForecast.temperature?.maximum?.unit
                minTemp.text = dayForecast.temperature?.minimum?.value.toString() + dayForecast.temperature?.minimum?.unit
                day.text = dayForecast.day?.iconPhrase
                night.text = dayForecast.night?.iconPhrase
            }
        }
    }
}

class ForecastDiffUtil : DiffUtil.ItemCallback<DayForecast>() {
    override fun areItemsTheSame(oldItem: DayForecast, newItem: DayForecast): Boolean {
        return oldItem.date == newItem.date
    }

    override fun areContentsTheSame(oldItem: DayForecast, newItem: DayForecast): Boolean {
        return oldItem == newItem
    }
}