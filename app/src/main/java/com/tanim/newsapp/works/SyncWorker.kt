package com.tanim.newsapp.works

import android.content.Context
import androidx.work.*
import com.tanim.newsapp.managers.DataManager
import com.tanim.newsapp.data.database.AppDatabase

class SyncWorker(context: Context, workerParams: WorkerParameters, dataManager: DataManager) :
    CoroutineWorker(context, workerParams) {
    private val dataManager: DataManager
    private val database: AppDatabase

    init {
        database = AppDatabase.createDatabase(context)
        this.dataManager = dataManager
    }

    override suspend fun doWork(): Result {
        val dataBuilder = Data.Builder()
        //TODO work here

        if(!dataManager.isLoggedIn()){
            dataBuilder.putString("error","No user found")
            return Result.failure(dataBuilder.build())
        }

        return Result.success()
    }

}