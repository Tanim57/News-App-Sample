package com.tanim.newsapp.managers

import com.tanim.newsapp.data.BasePageResponse
import com.tanim.newsapp.data.auth.LoginResponse
import com.tanim.newsapp.data.news.NewsResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {

    @GET("top-headlines")
    fun fetchHeadlines(@Query("country") country:String?,@Query("category") category:String?,@Query("apiKey") apiKey:String?,
                       @Query("page") page:Int? = null):
            Call<NewsResponse?>
}