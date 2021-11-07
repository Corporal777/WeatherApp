package org.otunjargych.weatherobserve.util

import org.otunjargych.weatherobserve.R

class IconProvider {

    companion object {
        fun getImageIcon(weatherDescription: String?): Int {
            return when (weatherDescription) {
                "Thunderstorm" -> R.drawable.ic_thunderstorm
                "Drizzle" -> R.drawable.ic_drizzle
                "Rain" -> R.drawable.ic_rain
                "Snow" -> R.drawable.ic_snow
                "Atmosphere" -> R.drawable.ic_atmosphere
                "Clear" -> R.drawable.ic_clear
                "Clouds" -> R.drawable.ic_cloudy
                "Extreme" -> R.drawable.ic_extreme
                else -> R.drawable.ic_clear
            }
        }
    }
}
