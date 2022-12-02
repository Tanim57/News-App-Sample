package com.tanim.newsapp.managers

import com.tanim.newsapp.data.database.AppDatabase
import com.tanim.newsapp.utils.NetworkUtils
import javax.inject.Singleton
import javax.inject.Inject

import java.util.*

@Singleton
class AppDataManager @Inject constructor(
    private val session: Session,
    private val preferenceManager: PreferenceManager
    //override val currentTime: Flow<Long>
) : DataManager {

    @Inject
    lateinit var networkUtils: NetworkUtils

    @Inject
    lateinit var appDataHelper: AppDataHelper

    override fun getEmail(): String? {
        return preferenceManager.getEmail()
    }


    @Synchronized
    override fun isLoggedIn(): Boolean {
        return session.isLoggedIn()
    }

    override fun isNetworkConnectionAvailable(): Boolean {
        return networkUtils.isNetworkConnected
    }

    @Synchronized
    override fun getApiToken(): String? {
        return session.getApiToken()
    }

    override fun setApiToken(apiToken: String?) {
        session.setApiToken(apiToken)
    }



    @Synchronized
    override fun getUser(): String? {
        return session.getUser()
    }


    override fun setUser(user: String?) {
        session.setUser(user)
    }

    @Synchronized
    override fun logOut() {
        if (isLoggedIn()) {
            session.logOut()
        }
    }

    @Synchronized
    override fun logIn() {
        session.logIn()
    }

    override fun setAuthenticationListener(listener: Session.AuthenticationListener) {
        session.setAuthenticationListener(listener)
    }

}