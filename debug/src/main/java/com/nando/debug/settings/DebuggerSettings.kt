package com.nando.debug.settings

import android.content.Context
import androidx.core.content.ContextCompat


class DebuggerSettings {

    val context: Context
    val bInDebugMode: Boolean
    val tag: String
    val bUseSingleTag: Boolean
    val bDisplayCustomTags: Boolean

    constructor(context: Context, bInDebugMode: Boolean) {
        this.context = context
        this.bInDebugMode = bInDebugMode
        this.tag = context.getString(context.applicationInfo.labelRes)
        this.bUseSingleTag = false
        this.bDisplayCustomTags = true
    }

    private constructor(context: Context, bInDebugMode: Boolean, tag: String, bUseSingleTag: Boolean, bDisplayCustomTags: Boolean) {
        this.context = context
        this.bInDebugMode = bInDebugMode
        this.tag = tag
        this.bUseSingleTag = bUseSingleTag
        this.bDisplayCustomTags = bDisplayCustomTags
    }

    class Builder(private val context: Context, private val bInDebugMode: Boolean) {

        private var tag: String = context.getString(context.applicationInfo.labelRes)
        private var bUseSingleTag: Boolean = false
        private var bDisplayCustomTags: Boolean = true

        fun setDefaultTag(tag: String): Builder {
            this.tag = tag
            return this
        }

        fun setUseSingleTag(bUseSingleTag: Boolean): Builder {
            this.bUseSingleTag = bUseSingleTag
            return this
        }

        fun setDisplayCustomTags(bDisplayCustomTags: Boolean): Builder {
            this.bDisplayCustomTags = bDisplayCustomTags
            return this
        }

        fun build(): DebuggerSettings {
            return DebuggerSettings(
                context,
                bInDebugMode,
                tag,
                bUseSingleTag,
                bDisplayCustomTags
            )
        }
    }
}