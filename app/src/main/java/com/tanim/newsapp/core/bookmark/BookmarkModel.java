package com.tanim.newsapp.core.bookmark;

import androidx.annotation.NonNull;

import com.tanim.newsapp.base.BaseViewModel;
import com.tanim.newsapp.managers.DataManager;
import com.tanim.newsapp.repository.DataRepository;

public class BookmarkModel extends BaseViewModel {


    public BookmarkModel(@NonNull DataManager dataManager, @NonNull DataRepository repository) {
        super(dataManager, repository);

    }


}
