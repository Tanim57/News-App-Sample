package com.tanim.newsapp.core.news;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.tanim.newsapp.BuildConfig;
import com.tanim.newsapp.base.BaseViewModel;
import com.tanim.newsapp.data.mapper.Resource;
import com.tanim.newsapp.data.news.NewsResponse;
import com.tanim.newsapp.managers.DataManager;
import com.tanim.newsapp.repository.DataRepository;
import com.tanim.newsapp.utils.AbsentLiveData;
import com.tigerit.attendanceclient.model.base.ResourceString;

public class NewsViewModel extends BaseViewModel {

    LiveData<Resource<NewsResponse, ResourceString>> lastResponse ;

    public NewsViewModel(@NonNull DataManager dataManager, @NonNull DataRepository repository) {
        super(dataManager, repository);
        fetchNews();
    }

    protected void fetchNews(){
        lastResponse = Transformations.switchMap(
                getRepository().fetchHeadlines(
                        "us", "business", BuildConfig.API_KEY, null), MutableLiveData::new);
    }



}
