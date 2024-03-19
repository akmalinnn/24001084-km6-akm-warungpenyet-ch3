package com.example.a24001084_km6_akm_warungpenyet_ch2.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import com.example.a24001084_km6_akm_warungpenyet_ch2.R
import com.example.a24001084_km6_akm_warungpenyet_ch2.databinding.ActivityCatalogDetailBinding
import com.example.a24001084_km6_akm_warungpenyet_ch2.model.Catalog
import com.example.a24001084_km6_akm_warungpenyet_ch2.utils.toIndonesianFormat

class DetailActivity : AppCompatActivity() {

    private var quantity: Int = 0

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
        setupQuantityButtons()

        binding.catalogDetail.ivBack.setOnClickListener {
            onBackPressed()
        }
    }


    private fun getIntentData() {
        intent.extras?.getParcelable<Catalog>(EXTRAS_DETAIL_DATA)?.let {
            binding.catalogDetail.ivCatalogImage.setImageResource(it.image)
            binding.catalogDetail.tvDesc.text = it.desc
            binding.catalogDetail.tvCatalogName.text = it.name
            binding.catalogDetail.tvCatalogPrice.text = it.price.toIndonesianFormat()
            binding.catalogLocation.tvCatalogLocation.text = it.location

            binding.catalogLocation.tvCatalogLocation.setOnClickListener {
                val catalog = intent.getParcelableExtra<Catalog>(EXTRAS_DETAIL_DATA)
                catalog?.locUrl.let { url ->
                    val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(mapIntent)
                }
            }
        }
    }


    private fun setupQuantityButtons() {
        binding.catalogCart.btnMinus.setOnClickListener {
            if (quantity > 0) {
                quantity--
                updateQuantityAndTotalPrice()
            }
        }

        binding.catalogCart.btnPlus.setOnClickListener {
            quantity++
            updateQuantityAndTotalPrice()
        }
    }

    private fun updateQuantityAndTotalPrice() {
        binding.catalogCart.tvCount.text = quantity.toString()
        val catalog = intent.getParcelableExtra<Catalog>(EXTRAS_DETAIL_DATA)
        val totalPrice = catalog?.price?.times(quantity) ?: 0.0

        if (quantity == 0) {
            binding.catalogCart.btnCheckout.text = getString(R.string.checkout)
        } else {
            //hard code
            "Total: ${totalPrice.toIndonesianFormat()}".also {
                binding.catalogCart.btnCheckout.text = it }
        }
    }
}