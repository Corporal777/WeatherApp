package org.otunjargych.weatherobserve.model

import com.google.gson.annotations.SerializedName

class Coord(
    @SerializedName("lon")
    val long: Float,
    @SerializedName("lat")
    val lat : Float
)