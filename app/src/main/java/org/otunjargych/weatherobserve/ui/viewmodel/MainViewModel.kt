package org.otunjargych.weatherobserve.ui.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.otunjargych.weatherobserve.api.ResponseHelper
import org.otunjargych.weatherobserve.model.Data
import org.otunjargych.weatherobserve.model.Resource
import org.otunjargych.weatherobserve.util.Keys
import org.otunjargych.weatherobserve.util.Utils

class MainViewModel : ViewModel() {


    private val _data: MutableLiveData<Resource<Data>> = MutableLiveData()
    val data: LiveData<Resource<Data>> = _data



    fun loadData(city: String, context: Context) {
        _data.value = Resource.Loading()
        if (Utils.checkTheInternet(context)) {
            viewModelScope.launch {
                val result = async {
                    ResponseHelper.getApi().getWeatherCity(city, Keys.KEY, "metric")
                }
                val response = result.await()
                if (response != null && response.isSuccessful) {
                    if (response.code() == 200) {
                        delay(1000)
                        _data.value = Resource.Success(response.body())
                    }

                }
            }
        } else {
            _data.value = Resource.NoConnection()
        }
    }


}