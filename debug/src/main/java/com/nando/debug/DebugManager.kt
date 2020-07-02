package com.nando.debug

import com.nando.debug.settings.DebuggerSettings

object DebugManager {

    var initialized: Boolean = false
    lateinit var settings: DebuggerSettings

    fun init(settings: DebuggerSettings) {
        this.initialized = true
        this.settings = settings
    }
}