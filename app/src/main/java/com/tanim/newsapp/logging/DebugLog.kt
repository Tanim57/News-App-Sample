package com.tanim.newsapp.logging

import android.util.Log
import com.tanim.newsapp.logging.DebugLog

object DebugLog {
    private const val DEBUG = true
    fun info(TAG: String?, message: String) {
        if (DEBUG) {
            val fullClassname = Thread.currentThread().stackTrace[3].className
            val className = fullClassname.substring(fullClassname.lastIndexOf(".") + 1)
            val methodName = Thread.currentThread().stackTrace[3].methodName
            val lineNumber = Thread.currentThread().stackTrace[3].lineNumber
            Log.i(TAG, "$className => $methodName[$lineNumber]: $message")
        }
    }

    fun wtf(TAG: String?, message: String) {
        if (DEBUG) {
            val fullClassname = Thread.currentThread().stackTrace[3].className
            val className = fullClassname.substring(fullClassname.lastIndexOf(".") + 1)
            val methodName = Thread.currentThread().stackTrace[3].methodName
            val lineNumber = Thread.currentThread().stackTrace[3].lineNumber
            Log.wtf(TAG, "$className => $methodName[$lineNumber]: $message")
        }
    }

    fun err(TAG: String?, message: String?, ex: Throwable?) {
        var message = message
        val fullClassname = Thread.currentThread().stackTrace[3].className
        val className = fullClassname.substring(fullClassname.lastIndexOf(".") + 1)
        val methodName = Thread.currentThread().stackTrace[3].methodName
        val lineNumber = Thread.currentThread().stackTrace[3].lineNumber
        if (message == null) {
            message = "ERROR"
        }
        Log.e(TAG, "$className => $methodName[$lineNumber]: $message", ex)
    }
}