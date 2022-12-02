package com.tanim.newsapp.managers

import com.tanim.newsapp.managers.DataHelper
import com.tanim.newsapp.data.database.AppDatabase
import javax.inject.Inject

class AppDataHelper @Inject constructor(
    private val session: Session,
    private val preferenceManager: PreferenceManager,
    private val database: AppDatabase?,
    //override val currentTime: Flow<Long>
) : DataHelper