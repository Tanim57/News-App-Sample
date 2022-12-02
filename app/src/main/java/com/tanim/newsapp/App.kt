package com.tanim.newsapp

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.BuildConfig
import androidx.multidex.MultiDex
import androidx.work.Configuration
import com.tanim.newsapp.App
import com.tanim.newsapp.di.component.AppComponent
import com.tanim.newsapp.di.component.DaggerAppComponent
import com.tanim.newsapp.logging.AppDebugTree
import com.tanim.newsapp.works.WorkerFactory
import timber.log.Timber

class App : Application(), Configuration.Provider {
    private val TAG = App::class.java.simpleName
    var appComponent: AppComponent? = null
    override fun onCreate() {
        super.onCreate()
        context = this@App
        if (BuildConfig.DEBUG) {
            Timber.plant(AppDebugTree())
        }
        appComponent = DaggerAppComponent.builder().application(this).build()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    companion object {
        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        }

        var context: Context? = null
            private set
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(WorkerFactory(appComponent?.getDataManager())) /*  .setExecutor(Executors.newFixedThreadPool(3))*/
            .build()
    }
}