package com.jithinsyamms.randomdog

import android.app.Application

class GlobalApplication: Application() {
    companion object {
        lateinit var instance: GlobalApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}