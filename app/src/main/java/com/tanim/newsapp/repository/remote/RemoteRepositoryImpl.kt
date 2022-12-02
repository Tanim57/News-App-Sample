package com.tanim.bcsadminclient.di.component
import com.tanim.newsapp.R
import com.tanim.newsapp.base.AppExecutors
import com.tanim.newsapp.base.SingleLiveEvent
import com.tanim.newsapp.data.mapper.Resource
import com.tanim.newsapp.data.mapper.Status
import com.tanim.newsapp.data.news.NewsResponse
import com.tanim.newsapp.managers.ApiInterface
import com.tanim.newsapp.managers.DataManager
import com.tanim.newsapp.repository.remote.RemoteRepository
import com.tanim.newsapp.utils.ErrorUtils
import com.tigerit.attendanceclient.model.base.IdResourceString
import com.tigerit.attendanceclient.model.base.ResourceString
import com.tigerit.attendanceclient.model.base.TextResourceString
import retrofit2.Response
import timber.log.Timber
import java.io.IOException


class RemoteRepositoryImpl(
    private val dataManager: DataManager
    , private val apiInterface: ApiInterface, private val appExecutors: AppExecutors
) : RemoteRepository {

    var newsResponse: SingleLiveEvent<Resource<NewsResponse?, ResourceString?>> =
        SingleLiveEvent()


    override fun fetchHeadlines(
        country: String?,
        category: String?,
        apiKey: String?,
        page:Int?
    ): SingleLiveEvent<Resource<NewsResponse?, ResourceString?>> {

        if(newsResponse.value?.status==Status.LOADING){
            return newsResponse
        }
        if (!dataManager.isNetworkConnectionAvailable()) {
            newsResponse.value = Resource.error(IdResourceString(R.string.error_no_connection))
            return newsResponse
        }

        newsResponse.value = Resource.loading()

        appExecutors.networkIO().execute {
            newsResponse.postValue(
                mapResponse(processCall (
                    apiInterface.fetchHeadlines(
                        country,
                        category,
                        apiKey,
                        page
                    ).execute()))
            )
        }

        return newsResponse
    }



    private inline fun <reified T:Any> mapResponse(response: Any?): Resource<T?, ResourceString?> {
        try {
            return when (response) {
                is T -> {
                    Resource.success(response)
                }
                is Int -> {
                    Resource.error(IdResourceString(response),null)
                }
                else -> {
                    Resource.error(response as ResourceString,null)
                }
            }
        }catch (e:Exception){
            Timber.e(e)
            return Resource.error(TextResourceString(e.message!!))
        }
    }


    private fun processCall(response: Response<*>): Any? {
        return try {
            //val response = responseCall.invoke()
            val responseCode = response.code()
            if (response.isSuccessful) {
                response.body()
            } else {
                TextResourceString(ErrorUtils.getCommonErrorFromCode(responseCode))
            }
        } catch (e: IOException) {
            return IdResourceString(R.string.error_failed_connection)
        }
    }


}