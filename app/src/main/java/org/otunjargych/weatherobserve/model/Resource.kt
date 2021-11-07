package org.otunjargych.weatherobserve.model

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(message: T) : Resource<T>(message)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class NoConnection<T>(data: T? = null) : Resource<T>(data)
}