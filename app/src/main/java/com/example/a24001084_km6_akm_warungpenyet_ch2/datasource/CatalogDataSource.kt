package com.example.a24001084_km6_akm_warungpenyet_ch2.datasource

import com.example.a24001084_km6_akm_warungpenyet_ch2.R
import com.example.a24001084_km6_akm_warungpenyet_ch2.model.Catalog

interface CatalogDataSource {
    fun getCatalogItem(): List<Catalog>
}

class CatalogDataSourceImpl() : CatalogDataSource {
    override fun getCatalogItem(): List<Catalog> {
        return mutableListOf(
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
    }

}