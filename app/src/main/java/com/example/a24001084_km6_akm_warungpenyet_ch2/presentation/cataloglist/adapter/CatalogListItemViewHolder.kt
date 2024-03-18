package com.example.a24001084_km6_akm_warungpenyet_ch2.presentation.cataloglist.adapter

import coil.load
import androidx.recyclerview.widget.RecyclerView
import com.example.a24001084_km6_akm_warungpenyet_ch2.R
import com.example.a24001084_km6_akm_warungpenyet_ch2.base.ViewHolderBinder
import com.example.a24001084_km6_akm_warungpenyet_ch2.databinding.ItemCatalogBinding
import com.example.a24001084_km6_akm_warungpenyet_ch2.model.Catalog
import com.example.a24001084_km6_akm_warungpenyet_ch2.utils.toIndonesianFormat

class CatalogListItemViewHolder(

    private val binding: ItemCatalogBinding,
    private val listener: OnItemClickedListener<Catalog>
) : RecyclerView.ViewHolder(binding.root), ViewHolderBinder<Catalog> {
    override fun bind(item: Catalog) {
        item.let {
            binding.ivCatalogImage.load(it.image) {
                crossfade(true)
                error(R.mipmap.ic_launcher)
            }
            binding.tvCatalogName.text = it.name
            binding.tvCatalogPrice.text = item.price.toIndonesianFormat()
            itemView.setOnClickListener {
                listener.onItemClicked(item)
            }
        }
    }
}