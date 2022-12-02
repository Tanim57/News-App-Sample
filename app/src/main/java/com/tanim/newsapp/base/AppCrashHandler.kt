package com.tanim.newsapp.base

import timber.log.Timber
import android.content.Intent
import com.tanim.newsapp.MainActivity

class AppCrashHandler(private val mActivity: BaseActivity<*, *>) : Thread.UncaughtExceptionHandler {
    override fun uncaughtException(thread: Thread, throwable: Throwable) {
        Timber.e(throwable)
        val intent = Intent(mActivity, MainActivity::class.java)
        intent.putExtra("crash", true)
        intent.addFlags(
            Intent.FLAG_ACTIVITY_CLEAR_TOP
                    or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    or Intent.FLAG_ACTIVITY_NEW_TASK
        )
        mActivity.baseContext.startActivity(intent)
        mActivity.finish()
        System.exit(2)
    }
}