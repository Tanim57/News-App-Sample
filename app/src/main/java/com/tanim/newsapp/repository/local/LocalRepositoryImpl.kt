package com.tanim.newsapp.repository.local

import android.content.Context
import com.tanim.newsapp.base.AppExecutors
import com.tanim.newsapp.data.database.AppDatabase
import com.tanim.newsapp.managers.DataManager

class LocalRepositoryImpl(
    private val context: Context,
    private val dataManager: DataManager,
    private val database: AppDatabase,
    private val appExecutors: AppExecutors
) : LocalRepository {

}