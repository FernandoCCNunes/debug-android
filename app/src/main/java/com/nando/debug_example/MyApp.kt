package com.nando.debug_example

import android.app.Application
import com.nando.debug.DebugManager
import com.nando.debug.settings.DebuggerSettings

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        DebugManager.init(
            DebuggerSettings.Builder(this, BuildConfig.DEBUG)
                .setUseSingleTag(true)
                .build()
        )
    }
}