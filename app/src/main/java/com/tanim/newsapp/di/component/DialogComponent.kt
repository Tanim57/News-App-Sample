package com.tanim.newsapp.di.component

import com.tanim.newsapp.di.scope.DialogScope
import com.tanim.newsapp.di.module.DialogModule
import com.tanim.newsapp.di.component.AppComponent
import dagger.Component

@DialogScope
@Component(modules = [DialogModule::class], dependencies = [AppComponent::class])
interface DialogComponent 