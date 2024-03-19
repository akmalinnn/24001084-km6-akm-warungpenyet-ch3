package com.example.a24001084_km6_akm_warungpenyet_ch2.datasource

import com.example.a24001084_km6_akm_warungpenyet_ch2.R
import com.example.a24001084_km6_akm_warungpenyet_ch2.model.Category

interface CategoryDataSource {
    fun getCategoryData(): List<Category>
}

class CategoryDataSourceImpl() : CategoryDataSource {
    override fun getCategoryData(): List<Category> {
        return mutableListOf(
            Category(image = R.drawable.img_rice_category, name = "Nasi"),
            Category(image = R.drawable.img_mie_category, name = "Mie"),
            Category(image = R.drawable.img_snack_category, name = "Snack"),
            Category(image = R.drawable.img_drink_category, name = "Minuman")
        )
    }
}