package com.tanim.newsapp.core.login

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tanim.newsapp.base.BaseViewModel
import com.tanim.newsapp.data.auth.LoginResponse
import com.tanim.newsapp.data.mapper.Resource
import com.tanim.newsapp.data.mapper.Status
import com.tanim.newsapp.managers.DataManager
import com.tanim.newsapp.repository.DataRepository
import com.tigerit.attendanceclient.model.base.ResourceString
import com.tigerit.attendanceclient.model.base.TextResourceString
import kotlinx.coroutines.launch

class LoginViewModel(
    dataManager: DataManager,
    repository: DataRepository
) : BaseViewModel(dataManager, repository) {

    val userName = ObservableField<String>()
    val password = ObservableField<String>()

    private val _loginResponse = MutableLiveData<Resource<LoginResponse, ResourceString>>()

    val loginResponse: LiveData<Resource<LoginResponse, ResourceString>>
        get() = _loginResponse

    fun login() {
        if (userName.get() == null) {
            errorMessage.value = TextResourceString("User name can't be empty")
            return
        }

        if (password.get() == null) {
            errorMessage.value = TextResourceString("Password can't be empty")
            return
        }

        if (_loginResponse.value?.status?.equals(Status.LOADING) == true) {
            return
        }

        _loginResponse.value = Resource.loading()

        viewModelScope.launch {
//            repository.login(userName.get().toString(), password.get().toString()).collect{
//                _loginResponse.value = it
//            }
        }

    }
}