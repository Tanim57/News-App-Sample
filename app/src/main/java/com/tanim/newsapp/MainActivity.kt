package com.tanim.newsapp

import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.tanim.newsapp.base.BaseActivity
import com.tanim.newsapp.databinding.ActivityMainBinding
import com.tanim.newsapp.di.component.ActivityComponent

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {


    private lateinit var navController: NavController

    override val bindingVariable
        get() = BR.viewModel

    override val layout: Int
        get() = R.layout.activity_main


    override fun performDependencyInjection(buildComponent: ActivityComponent) {
        buildComponent.inject(this);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.nav_host_container
        ) as NavHostFragment

        navController = navHostFragment.navController

    }
}