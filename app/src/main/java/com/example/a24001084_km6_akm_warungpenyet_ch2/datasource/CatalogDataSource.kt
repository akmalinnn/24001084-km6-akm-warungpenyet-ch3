package com.example.a24001084_km6_akm_warungpenyet_ch2.datasource

import com.example.a24001084_km6_akm_warungpenyet_ch2.R
import com.example.a24001084_km6_akm_warungpenyet_ch2.model.Catalog

interface CatalogDataSource {
    fun getCatalogItem(): List<Catalog>
}

class CatalogDataSourceImpl() : CatalogDataSource {
    override fun getCatalogItem(): List<Catalog> {
        return mutableListOf(
            Catalog(
                image = R.drawable.img_ayam,
                name = "Penyetan Ayam",
                price = 15000.0,
                desc = "Penyetan ayam dengan sambal pedas dengan bahan yang fresh di goreng sempurna",
                location = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                locUrl = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Catalog(
                image = R.drawable.img_ayam_komplit,
                name = "Penyetan komplit",
                price = 20000.0,
                desc = "Penyetan komplit berisi tahu tempe, dan ayam dengan lauk yang komplit beserta lalapan segar",
                location = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                locUrl = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Catalog(
                image = R.drawable.img_lele,
                name = "lele Goreng",
                price = 15000.0,
                desc = "Lele goreng dengan sambal spesial, dengan ukuran dan porsi yang pas",
                location = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                locUrl = "https://maps.app.goo.gl/PMNhsNu9WoJS594f6"
            ),
            Catalog(
                image = R.drawable.img_belut,
                name = "Penyetan Belut",
                price = 17000.0,
                desc = "Penyetan belut dengan varian rasa dengan sambal pedah khas",
                location = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                locUrl = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Catalog(
                image = R.drawable.img_tahu_tempe,
                name = "Tahu Tempe",
                price = 12000.0,
                desc = "Menu makanan favorit dengan porsi yang besar, cocok untuk dimakan setiap hari",
                location = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                locUrl = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Catalog(
                image = R.drawable.img_indomie,
                name = "Indomie Special",
                price = 8000.0,
                desc = "Indomie Special, indomie goreng disajikan dengan sempurna dengan tambahan telur goreng",
                location = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                locUrl = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Catalog(
                image = R.drawable.img_esteh,
                name = "Es teh Manis",
                price = 3000.0,
                desc = "Esteh manis porsi sedang, cocok disajikan dengan semua penyetan",
                location = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345",
                locUrl = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            )

        )
    }

}