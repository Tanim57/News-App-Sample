package com.tanim.newsapp.managers

import androidx.databinding.ObservableField
import com.tanim.newsapp.data.database.AppDatabase


interface DataManager : PreferenceManager, Session, DataHelper {

    fun isNetworkConnectionAvailable(): Boolean

}