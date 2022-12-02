package com.tanim.newsapp.di.module

import androidx.core.util.Supplier
import com.tanim.newsapp.base.BaseActivity
import com.tanim.newsapp.base.ViewModelFactory
import androidx.lifecycle.ViewModelProvider
import com.tanim.newsapp.MainViewModel
import com.tanim.newsapp.repository.DataRepository
import com.tanim.newsapp.managers.DataManager
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: BaseActivity<*, *>) {
    @Provides
    fun provideMainViewModel(dataManager: DataManager,repository: DataRepository): MainViewModel {

        val supplier: Supplier<MainViewModel> =
            Supplier { MainViewModel(dataManager,repository) }

        val factory: ViewModelFactory<MainViewModel> =
            ViewModelFactory<MainViewModel>(MainViewModel::class.java, supplier)

        return ViewModelProvider(activity, factory).get(MainViewModel::class.java)
    }
}