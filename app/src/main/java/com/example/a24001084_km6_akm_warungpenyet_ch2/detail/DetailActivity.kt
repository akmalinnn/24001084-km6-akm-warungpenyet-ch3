package com.example.a24001084_km6_akm_warungpenyet_ch2.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a24001084_km6_akm_warungpenyet_ch2.databinding.ActivityCatalogDetailBinding
import com.example.a24001084_km6_akm_warungpenyet_ch2.model.Catalog
import com.example.a24001084_km6_akm_warungpenyet_ch2.utils.toIndonesianFormat

class DetailActivity : AppCompatActivity() {

    companion object {

        const val EXTRAS_DETAIL_DATA = "EXTRAS_DETAIL_DATA"
        fun startActivity(context: Context, catalog: Catalog) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRAS_DETAIL_DATA, catalog)
            context.startActivity(intent)
        }
    }


    private val binding: ActivityCatalogDetailBinding by lazy {
        ActivityCatalogDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getIntentData()
    }

    private fun getIntentData() {
        intent.extras?.getParcelable<Catalog>(EXTRAS_DETAIL_DATA)?.let {
            binding.ivCatalogImage.setImageResource(it.image)
            binding.tvCatalogName.text = it.name
            binding.tvCatalogPrice.text = it.price.toIndonesianFormat()
        }
    }

}