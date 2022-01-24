package com.github.rogerp91.mao_trailer_android.mao_trailer.application.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.github.rogerp91.mao_trailer_android.mao_trailer.application.R
import com.github.rogerp91.mao_trailer_android.mao_trailer.application.main.MainNavigationActivity

import android.content.Intent

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            val i = Intent(this@SplashActivity, MainNavigationActivity::class.java)
            startActivity(i)
            finish()
        }, 3000)
    }
}