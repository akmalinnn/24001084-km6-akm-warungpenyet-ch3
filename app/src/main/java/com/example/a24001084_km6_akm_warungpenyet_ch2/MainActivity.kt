package com.example.a24001084_km6_akm_warungpenyet_ch2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import com.example.a24001084_km6_akm_warungpenyet_ch2.adapter.CatalogAdapter
import com.example.a24001084_km6_akm_warungpenyet_ch2.adapter.CategoryAdapter
import com.example.a24001084_km6_akm_warungpenyet_ch2.databinding.ActivityMainBinding
import com.example.a24001084_km6_akm_warungpenyet_ch2.model.Catalog
import com.example.a24001084_km6_akm_warungpenyet_ch2.model.Category

class MainActivity : AppCompatActivity() {


    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val adapterCategory = CategoryAdapter()
    private val adapterCatalog = CatalogAdapter()
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

    private fun setListCatalog() {
        val data = listOf(
            Catalog(image = R.drawable.img_ayam, name = "Penyetan Ayam", price = 15000.0),
            Catalog(
                image = R.drawable.img_ayam_komplit,
                name = "Penyetan komplit",
                price = 20000.0
            ),
            Catalog(image = R.drawable.img_lele, name = "lele Goreng", price = 15000.0),
            Catalog(image = R.drawable.img_belut, name = "Penyetan Belut", price = 17000.0),
            Catalog(image = R.drawable.img_tahu_tempe, name = "Tahu Tempe", price = 12000.0),
            Catalog(image = R.drawable.img_indomie, name = "Indomie Special", price = 8000.0),
            Catalog(image = R.drawable.img_esteh, name = "Es teh Manis", price = 3000.0)

        )
        binding.rvCatalog.apply {
            adapter = this@MainActivity.adapterCatalog
        }
        adapterCatalog.submitData(data)
    }

}
