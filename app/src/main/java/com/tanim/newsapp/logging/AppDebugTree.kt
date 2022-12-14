package com.tanim.newsapp.logging

import com.tanim.newsapp.BuildConfig
import timber.log.Timber.DebugTree

open class AppDebugTree : DebugTree() {
    override fun createStackElementTag(element: StackTraceElement): String? {
        val format: String = if (BuildConfig.DEBUG) {
            "AppTAG [%s => %s:%s]"
        } else {
            "[%s => %s:%s]"
        }
        return String.format(
            format, super.createStackElementTag(element),
            element.methodName, element.lineNumber
        )
    }
}