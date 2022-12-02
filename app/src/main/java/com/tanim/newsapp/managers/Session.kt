package com.tanim.newsapp.managers

interface Session {
    fun isLoggedIn(): Boolean
    fun getUser():String?
    fun setUser(user: String?)
    fun getApiToken():String?
    fun setApiToken(token:String?)

    fun logOut()
    fun logIn()

    interface AuthenticationListener {
        fun onUserLoggedOut()
        fun onUserLogIn()
    }

    fun setAuthenticationListener(listener: AuthenticationListener)
}