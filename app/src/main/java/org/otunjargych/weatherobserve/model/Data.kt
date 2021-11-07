package org.otunjargych.weatherobserve.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("coord")
    val coord : Coord,
    @SerializedName("weather")
    val weather : List<Weather>,
    @SerializedName("main")
    val main : Details,
    @SerializedName("wind")
    val wind : Wind,
    @SerializedName("clouds")
    val clouds: Clouds,
    @SerializedName("sys")
    val sys : Sys,
    @SerializedName("name")
    val cityName : String
)