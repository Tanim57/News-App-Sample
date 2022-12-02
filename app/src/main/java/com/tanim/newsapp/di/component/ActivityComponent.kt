package com.tanim.newsapp.di.component

import com.tanim.newsapp.di.scope.ActivityScope
import com.tanim.newsapp.di.module.ActivityModule
import com.tanim.newsapp.di.component.AppComponent
import com.tanim.newsapp.MainActivity
import dagger.Component

@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [AppComponent::class])
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}