package com.tanim.newsapp.repository

import androidx.lifecycle.LiveData
import com.tanim.newsapp.base.SingleLiveEvent
import com.tanim.newsapp.data.auth.LoginResponse
import com.tanim.newsapp.data.mapper.Resource
import com.tanim.newsapp.data.news.NewsResponse
import com.tigerit.attendanceclient.model.base.ResourceString
import kotlinx.coroutines.flow.Flow

interface DataRepository {
    fun fetchHeadlines(country:String?,category:String?,apiKey:String?,page:Int?):
            LiveData<Resource<NewsResponse?, ResourceString?>?>
}