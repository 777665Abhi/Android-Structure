package com.sachy.androidstructure.login

import android.content.Context

class LoginRepository(apiClient: String, context: Context) {

    fun login(username: String, password: String, mCallback: LoginRepositoryCallback) {
        if (username == "User" && password == "1234") {
            mCallback.loginSuccess(LoginResponse(username,password))
        } else {
            mCallback.loginFailure("Error to login")
        }
    }


    interface LoginRepositoryCallback {
        fun loginSuccess(msg: LoginResponse?)
        fun loginFailure(msg: String)
    }
}