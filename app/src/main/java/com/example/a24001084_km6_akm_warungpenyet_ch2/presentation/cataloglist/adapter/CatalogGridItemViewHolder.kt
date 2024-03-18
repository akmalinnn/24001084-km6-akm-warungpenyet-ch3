package com.example.a24001084_km6_akm_warungpenyet_ch2.presentation.cataloglist.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.a24001084_km6_akm_warungpenyet_ch2.R
import com.example.a24001084_km6_akm_warungpenyet_ch2.base.ViewHolderBinder
import com.example.a24001084_km6_akm_warungpenyet_ch2.databinding.ItemCatalogGridBinding
import com.example.a24001084_km6_akm_warungpenyet_ch2.model.Catalog
import com.example.a24001084_km6_akm_warungpenyet_ch2.utils.toIndonesianFormat

class CatalogGridItemViewHolder (
    private val binding: ItemCatalogGridBinding,
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