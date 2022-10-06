package com.example.pyalungan

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.pyalungan.databinding.ActivityLoginBinding

class LoginActivity: AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences(USER_NAME, Context.MODE_PRIVATE)
        binding.buttonEnter.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if(binding.personName.text.isEmpty()){
            binding.personName.error = "Required"
            return
        }

        val editor = sharedPreferences.edit()
        editor.putString(USER_NAME,binding.personName.text.toString())
        editor.apply()

        val intent = Intent(this,MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)

    }

}