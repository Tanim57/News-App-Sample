package com.tanim.newsapp

import com.tanim.newsapp.base.BaseViewModel
import com.tanim.newsapp.repository.DataRepository
import com.tanim.newsapp.managers.DataManager

class MainViewModel(dataManager: DataManager, repository: DataRepository) :
    BaseViewModel(dataManager, repository) {
}