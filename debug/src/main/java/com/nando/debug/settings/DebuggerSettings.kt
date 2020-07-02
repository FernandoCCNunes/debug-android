package com.nando.debug.settings

import android.content.Context
import androidx.core.content.ContextCompat


class DebuggerSettings private constructor(
    val context: Context,
    val bInDebugMode: Boolean,
    val tag: String,
    val bUseSingleTag: Boolean,
    val bDisplayCustomTags: Boolean
) {

    class Builder(private val context: Context, private val bInDebugMode: Boolean) {

        private var tag: String = context.getString(context.applicationInfo.labelRes)
        private var bUseSingleTag: Boolean = false
        private var bDisplayCustomTags: Boolean = false

        fun setDefaultTag(tag: String): Builder {
            this.tag = tag
            return this
        }

        fun setUseSingleTag(bUseSingleTag: Boolean, bDisplayCustomTags: Boolean = false): Builder {
            this.bUseSingleTag = bUseSingleTag
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