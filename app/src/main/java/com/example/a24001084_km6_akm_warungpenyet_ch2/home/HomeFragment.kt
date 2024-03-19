package com.example.a24001084_km6_akm_warungpenyet_ch2.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.a24001084_km6_akm_warungpenyet_ch2.R
import com.example.a24001084_km6_akm_warungpenyet_ch2.databinding.FragmentHomeBinding
import com.example.a24001084_km6_akm_warungpenyet_ch2.datasource.CatalogDataSource
import com.example.a24001084_km6_akm_warungpenyet_ch2.datasource.CatalogDataSourceImpl
import com.example.a24001084_km6_akm_warungpenyet_ch2.datasource.CategoryDataSource
import com.example.a24001084_km6_akm_warungpenyet_ch2.datasource.CategoryDataSourceImpl
import com.example.a24001084_km6_akm_warungpenyet_ch2.detail.DetailActivity
import com.example.a24001084_km6_akm_warungpenyet_ch2.model.Catalog
import com.example.a24001084_km6_akm_warungpenyet_ch2.presentation.adapter.CategoryAdapter
import com.example.a24001084_km6_akm_warungpenyet_ch2.presentation.cataloglist.adapter.CatalogAdapter
import com.example.a24001084_km6_akm_warungpenyet_ch2.presentation.cataloglist.adapter.OnItemClickedListener

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val adapterCategory = CategoryAdapter()
    private var adapterCatalog: CatalogAdapter? = null
    private var isUsingGridMode: Boolean = true

    private val dataSourceCatalog: CatalogDataSource by lazy {
        CatalogDataSourceImpl()
    }
    private val dataSourceCategory: CategoryDataSource by lazy {
        CategoryDataSourceImpl()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setListCategory() {
        binding.rvCategory.apply {
            adapter = this@HomeFragment.adapterCategory
        }
        adapterCategory.submitData(dataSourceCategory.getCategoryData())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListCategory()
        bindCatalogList(isUsingGridMode)
        setClickActionMenu()
    }

    private fun setClickActionMenu() {
        binding.listMenu.ibSortMenu.setOnClickListener {
            isUsingGridMode = !isUsingGridMode
            setButtonImage(isUsingGridMode)
            bindCatalogList(isUsingGridMode)
        }
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
            adapter = this@HomeFragment.adapterCatalog
            layoutManager = GridLayoutManager(requireContext(), if (isUsingGridMode) 2 else 1)
        }
        adapterCatalog?.submitData(dataSourceCatalog.getCatalogItem())
    }

    private fun navigateToDetail(item : Catalog) {
        DetailActivity.startActivity(requireContext(),item)
    }

    private fun setButtonImage(isUsingGrid: Boolean) {
        binding.listMenu.ibSortMenu.setImageResource(if (isUsingGrid) R.drawable.ic_menu else R.drawable.ic_sort_menu)
    }

}