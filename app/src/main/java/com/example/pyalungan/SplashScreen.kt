package com.example.pyalungan

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.pyalungan.LoginActivity
import com.example.pyalungan.MainActivity
import com.example.pyalungan.R
import com.example.pyalungan.USER_NAME

class SplashScreen: AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        sharedPreferences = getSharedPreferences(USER_NAME, Context.MODE_PRIVATE)

        supportActionBar?.hide()

        object : CountDownTimer(2000, 1000) {
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                val username = sharedPreferences.getString(USER_NAME,"")
                if(username == ""){
                    val intent = Intent(this@SplashScreen,LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                }else{
                    val intent = Intent(this@SplashScreen,MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                }
            }

        }.start()

    }
}