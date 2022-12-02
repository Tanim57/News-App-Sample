package com.tanim.newsapp.core.newdetails;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import com.tanim.newsapp.base.BaseViewModel;
import com.tanim.newsapp.data.news.Article;
import com.tanim.newsapp.managers.DataManager;
import com.tanim.newsapp.repository.DataRepository;

public class NewsDetailViewModel extends BaseViewModel {

    public ObservableField<Article> article = new ObservableField<>();

    public NewsDetailViewModel(@NonNull DataManager dataManager, @NonNull DataRepository repository) {
        super(dataManager, repository);
    }


}
