package com.tanim.newsapp.core.home

import com.tanim.newsapp.base.BaseViewModel
import com.tanim.newsapp.managers.DataManager
import com.tanim.newsapp.repository.DataRepository

class HomeViewModel(
    dataManager: DataManager,
    repository: DataRepository
) : BaseViewModel(dataManager, repository)