package org.otunjargych.weatherobserve.model

import com.google.gson.annotations.SerializedName

class Wind(
    @SerializedName("speed")
    val speed : Double,
    @SerializedName("deg")
    val deg : Int,
    @SerializedName("gust")
    val gust : Double
)