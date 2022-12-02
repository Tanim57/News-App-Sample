
package com.tanim.newsapp.repository.remote

import com.tanim.newsapp.base.SingleLiveEvent
import com.tanim.newsapp.data.mapper.Resource
import com.tanim.newsapp.data.news.NewsResponse
import com.tigerit.attendanceclient.model.base.ResourceString
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteRepository {

    fun fetchHeadlines(country:String?,category:String?,apiKey:String?,page:Int?):
            SingleLiveEvent<Resource<NewsResponse?, ResourceString?>>

}