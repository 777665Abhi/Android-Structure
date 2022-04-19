package com.sachy.androidstructure.utils

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class AppPreferences {
    companion object {
        const val name = "SharePreferenceData"
        private const val LOGIN_KEY = "login"
        private const val ACCESS_TOKEN="accessToken"

        fun setLoginStatus(activity: Activity, loginStatus: Boolean,accessToken:String) {
            val sharedPreferences: SharedPreferences = activity.getSharedPreferences(name, Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putBoolean(LOGIN_KEY, loginStatus)
            editor.putString(ACCESS_TOKEN, accessToken)

            editor.commit()
        }

        fun  getLoginStatus(activity: Activity):Boolean
        {
            val sharedPreferences: SharedPreferences = activity.getSharedPreferences(name, Context.MODE_PRIVATE)
            return sharedPreferences.getBoolean(LOGIN_KEY,false)
        }

        fun getAccessToken(activity: Activity): String?
        {
            val sharedPreferences: SharedPreferences = activity.getSharedPreferences(name, Context.MODE_PRIVATE)
            return sharedPreferences.getString(ACCESS_TOKEN,"")
        }
    }
}