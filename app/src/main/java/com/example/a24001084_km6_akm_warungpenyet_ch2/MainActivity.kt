package com.example.a24001084_km6_akm_warungpenyet_ch2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import com.example.a24001084_km6_akm_warungpenyet_ch2.adapter.CategoryAdapter
import com.example.a24001084_km6_akm_warungpenyet_ch2.databinding.ActivityMainBinding
import com.example.a24001084_km6_akm_warungpenyet_ch2.model.Category

class MainActivity : AppCompatActivity() {


    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val adapterCategory = CategoryAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setListCategory()
    }

    private fun setListCategory() {
        val data = listOf(
            Category(image = R.drawable.img_rice_category, name = "Nasi"),
            Category(image = R.drawable.img_mie_category, name = "Mie"),
            Category(image = R.drawable.img_snack_category, name = "Snack"),
            Category(image = R.drawable.img_drink_category, name = "Minuman")
        )
        binding.rvCategory.apply {
            adapter = this@MainActivity.adapterCategory
        }
        adapterCategory.submitData(data)
    }


}
