
package com.tanim.newsapp.repository

import androidx.lifecycle.LiveData
import com.tanim.newsapp.data.mapper.Resource
import com.tanim.newsapp.data.news.NewsResponse
import com.tanim.newsapp.repository.local.LocalRepository
import com.tanim.newsapp.repository.remote.RemoteRepository
import com.tigerit.attendanceclient.model.base.ResourceString
import kotlin.coroutines.CoroutineContext

class DataRepositoryImpl (private val remoteRepository: RemoteRepository,
                          private val localRepository: LocalRepository,
                          private val ioDispatcher: CoroutineContext
): DataRepository {
    override fun fetchHeadlines(
        country: String?,
        category: String?,
        apiKey: String?,
        page: Int?
    ): LiveData<Resource<NewsResponse?, ResourceString?>?> {
        return remoteRepository.fetchHeadlines(country,category,apiKey,page)
    }

}
