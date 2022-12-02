package com.tanim.newsapp.di.component

import com.tanim.newsapp.core.bookmark.BookMarkFragment
import com.tanim.newsapp.core.home.HomeFragment
import com.tanim.newsapp.core.login.LoginFragment
import com.tanim.newsapp.core.newdetails.NewsDetailFragment
import com.tanim.newsapp.core.news.NewsFragment
import com.tanim.newsapp.di.module.FragmentModule
import com.tanim.newsapp.di.scope.FragmentScope
import dagger.Component

@FragmentScope
@Component(modules = [FragmentModule::class], dependencies = [AppComponent::class])
interface FragmentComponent {
    fun inject(loginFragment: LoginFragment)
    fun inject(homeFragment: HomeFragment)
    fun inject(newsFragment: NewsFragment)
    fun inject(newsDetailFragment: NewsDetailFragment)
    fun inject(bookMarkFragment: BookMarkFragment);
} 