package com.example.pyalungan

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.pyalungan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences(USER_NAME,Context.MODE_PRIVATE)
        binding.welcomeMessage.text = String.format("Hi, %s! Let's Play!",sharedPreferences.getString(
            USER_NAME,""))
        binding.choose.setOnClickListener(this)
        binding.logout.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            (R.id.choose) -> {
                val fragmentManager = supportFragmentManager.beginTransaction()
                fragmentManager.replace(binding.fragmentContainer.id, MainFragment())

                fragmentManager.commit()
            }
                (R.id.logout) ->{
                val editor = sharedPreferences.edit()
                editor.clear()
                editor.apply()

                val intent = Intent(this,LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)

            }
        }
    }

}
