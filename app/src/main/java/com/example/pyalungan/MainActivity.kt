package com.example.pyalungan

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            (R.id.button) -> {
                val fragmentManager = supportFragmentManager.beginTransaction()
                fragmentManager.replace(binding.fragmentContainer.id, MainFragment())

                fragmentManager.commit()
            }
        }
    }

}
