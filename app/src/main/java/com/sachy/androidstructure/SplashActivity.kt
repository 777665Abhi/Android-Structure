package com.sachy.androidstructure

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.sachy.androidstructure.home.HomeActivity
import com.sachy.androidstructure.login.LoginActivity
import com.sachy.androidstructure.utils.AppPreferences

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun init() {
        Handler(Looper.getMainLooper()).postDelayed({
            intent = if (AppPreferences.getLoginStatus(this))
                Intent(this, HomeActivity::class.java)
            else Intent(this, LoginActivity::class.java)

            startActivity(intent)
            finish()
        }, 100)
    }
}