package org.otunjargych.weatherobserve.api

import org.otunjargych.weatherobserve.model.Data
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ResponseService {

    @GET("data/2.5/weather?")
    suspend fun getWeatherCity(
        @Query("q") city: String?,
        @Query("appid") key: String?,
        @Query("units") units: String?

    ): Response<Data?>?

}