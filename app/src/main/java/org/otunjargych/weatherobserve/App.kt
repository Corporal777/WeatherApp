package org.otunjargych.weatherobserve

import android.app.Application
import android.content.Context

class App : Application() {

    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
//        val config = YandexMetricaConfig.newConfigBuilder(Values.YANDEX_API_KEY).build()
//        YandexMetrica.activate(applicationContext, config)
//        YandexMetrica.enableActivityAutoTracking(this)
        context = this

    }

}