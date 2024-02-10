package com.example.islamy.splashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.islamy.HomeActivity
import com.example.islamy.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

startToHomeActivity()

    }

    private fun startToHomeActivity() {
        Handler(Looper.getMainLooper()).postDelayed({
            var intent= Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
            finish()
        },2000)
    }


}

