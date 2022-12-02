package com.tanim.newsapp.di.module

import android.content.Context
import com.tanim.newsapp.base.BaseDialog
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.Module
import dagger.Provides

@Module
class DialogModule(private val dialog: BaseDialog<*, *>) {
    @Provides
    fun provideContext(): Context {
        return dialog.requireContext()
    }

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager {
        return LinearLayoutManager(dialog.requireContext())
    }
}