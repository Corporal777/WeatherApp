package org.otunjargych.weatherobserve.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.otunjargych.weatherobserve.databinding.ItemLayoutBinding
import org.otunjargych.weatherobserve.model.Data
import org.otunjargych.weatherobserve.util.IconProvider

class WeatherAdapter(
    private val context: Context,
) : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    private var list = ArrayList<Data>()

    fun swapData(newList: List<Data>) {
        this.list = newList as ArrayList<Data>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                bind(this)
            }
        }
    }

    inner class ViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cityWeather: Data) = with(binding) {
            Picasso.get().load(IconProvider.getImageIcon(cityWeather.weather[0].main))
                .into(ivWeatherIcon)
            (", " + cityWeather.sys.country).also { tvCountryName.text = it }
            tvWeatherDescription.text = cityWeather.weather[0].description
            tvCityName.text =
                cityWeather.cityName
            tvCurrentTemp.text = cityWeather.main.temp.toString() + "°"
            tvMaxTemp.text = cityWeather.main.temp_max.toString() + "°"
            tvMinTemp.text = cityWeather.main.temp_min.toString() + "°"
            tvFeelsTemp.text = cityWeather.main.feels_like.toString() + "°"
            tvHumidity.text = cityWeather.main.humidity.toString() + "%"
            tvWind.text = cityWeather.wind.speed.toString() + " m/s"
            tvCloudiness.text = cityWeather.clouds.all.toString() + "%"
            tvPressure.text = cityWeather.main.pressure.toString() + " hPa"
        }
    }
}