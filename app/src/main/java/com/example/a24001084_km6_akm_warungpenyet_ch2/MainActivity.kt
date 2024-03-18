package com.example.a24001084_km6_akm_warungpenyet_ch2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.a24001084_km6_akm_warungpenyet_ch2.presentation.adapter.CategoryAdapter
import com.example.a24001084_km6_akm_warungpenyet_ch2.databinding.ActivityMainBinding
import com.example.a24001084_km6_akm_warungpenyet_ch2.datasource.CatalogDataSource
import com.example.a24001084_km6_akm_warungpenyet_ch2.datasource.CatalogDataSourceImpl
import com.example.a24001084_km6_akm_warungpenyet_ch2.detail.DetailActivity
import com.example.a24001084_km6_akm_warungpenyet_ch2.model.Catalog
import com.example.a24001084_km6_akm_warungpenyet_ch2.model.Category
import com.example.a24001084_km6_akm_warungpenyet_ch2.presentation.cataloglist.adapter.CatalogAdapter
import com.example.a24001084_km6_akm_warungpenyet_ch2.presentation.cataloglist.adapter.OnItemClickedListener

class MainActivity : AppCompatActivity() {
    private val adapterCategory = CategoryAdapter()
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val dataSourceMenu: CatalogDataSource by lazy {
        CatalogDataSourceImpl()
    }
    private var adapterCatalog:CatalogAdapter? = null
    private var isUsingGridMode: Boolean = true



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setListCategory()
        bindCatalogList(isUsingGridMode)
        setClickActionMenu()
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

    private fun setClickActionMenu() {
        binding.listMenu.ibSortMenu.setOnClickListener {
            isUsingGridMode = !isUsingGridMode
            setButtonImage(isUsingGridMode)
            bindCatalogList(isUsingGridMode)
        }
    }

    private fun setButtonImage(isUsingGrid: Boolean) {
        binding.listMenu.ibSortMenu.setImageResource(if (isUsingGrid) R.drawable.ic_menu else R.drawable.ic_sort_menu)
    }

    private fun bindCatalogList(isUsingGrid: Boolean) {
        val listMode = if (isUsingGrid) CatalogAdapter.MODE_GRID else CatalogAdapter.MODE_LIST
        adapterCatalog = CatalogAdapter(
            listMode = listMode,
            listener = object : OnItemClickedListener<Catalog> {
                override fun onItemClicked(item: Catalog) {
                    navigateToDetail(item)
                }

            }
        )
        binding.rvCatalog.apply {
            adapter = this@MainActivity.adapterCatalog
            layoutManager = GridLayoutManager(this@MainActivity, if (isUsingGridMode) 2 else 1)
        }
        adapterCatalog?.submitData(dataSourceMenu.getCatalogItem())
    }

    private fun navigateToDetail(item : Catalog) {
        DetailActivity.startActivity(this,item)
    }

}
