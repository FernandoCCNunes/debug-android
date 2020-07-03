package com.nando.debug

import android.content.Context
import android.util.Log
import com.nando.debug.exceptions.DebugManagerNotInitialized

class Debug {

    private var tag: String? = null
    private val message: String

    constructor(message: String) {
        this.message = message
    }

    constructor(tag: String, message: String) {
        this.tag = tag
        this.message = message
    }

    constructor(tag: Any, message: String) {
        this.tag = tag.javaClass.simpleName
        this.message = message
    }

    fun error() {
        if (canDisplayLog()) {
            Log.e(getTag(), getMessage())
        }
    }

    fun warning() {
        if (canDisplayLog()) {
            Log.w(getTag(), getMessage())
        }
    }

    fun information() {
        if (canDisplayLog()) {
            Log.i(getTag(), getMessage())
        }
    }

    fun debug() {
        if (canDisplayLog()) {
            Log.d(getTag(), getMessage())
        }
    }

    fun verbose() {
        if (canDisplayLog()) {
            Log.v(getTag(), getMessage())
        }
    }

    private fun canDisplayLog(): Boolean {
        if (!isManagerInitialized()) throw DebugManagerNotInitialized()
        return DebugManager.settings.bInDebugMode
    }

    private fun isManagerInitialized(): Boolean {
        return DebugManager.initialized
    }

    private fun getTag(): String {
        if (!isManagerInitialized()) throw DebugManagerNotInitialized()
        if (DebugManager.settings.bUseSingleTag) return DebugManager.settings.tag
        return tag?: DebugManager.settings.tag
    }

    private fun getMessage(): String {
        if (!isManagerInitialized()) throw DebugManagerNotInitialized()
        if (tag != null && DebugManager.settings.bUseSingleTag && DebugManager.settings.bDisplayCustomTags) {
            return "$tag -> $message"
        }
        return message
    }
}