
package com.tanim.newsapp.di.component

import android.app.Application
import com.tanim.newsapp.App
import com.tanim.newsapp.base.AppExecutors
import com.tanim.newsapp.repository.DataRepository
import com.tanim.newsapp.di.module.AppModule
import com.tanim.newsapp.managers.DataManager
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(app: App)
    fun getDataManager(): DataManager
    fun getDataRepository(): DataRepository
    fun getAppExecutors(): AppExecutors

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}