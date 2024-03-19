package com.example.a24001084_km6_akm_warungpenyet_ch2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a24001084_km6_akm_warungpenyet_ch2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

}
