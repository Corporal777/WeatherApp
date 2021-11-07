package org.otunjargych.weatherobserve.model

import com.google.gson.annotations.SerializedName

class Sys(
    @SerializedName("country")
    val country: String,
    @SerializedName("sunrise")
    val sunrise: Int,
    @SerializedName("sunset")
    val sunset: Int
)