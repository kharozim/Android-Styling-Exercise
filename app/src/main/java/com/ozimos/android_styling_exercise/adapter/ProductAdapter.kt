package com.ozimos.android_styling_exercise.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import com.ozimos.android_styling_exercise.R
import com.ozimos.android_styling_exercise.api.ProductModel
import com.ozimos.android_styling_exercise.databinding.ItemProductsBinding

class ProductAdapter(private val context: Context) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    private var products = listOf<ProductModel>()

    fun setData(data: List<ProductModel>) {
        products = data
        notifyDataSetChanged()
    }

    inner class ViewHolder(private var binding: ItemProductsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(product: ProductModel) {
            binding.tvNameProduct.text = product.title
            binding.tvPrice.text = "$${product.price}"
            Glide.with(binding.root).load(product.imageUrl).into(binding.ivImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        return ViewHolder(
            ItemProductsBinding.inflate(LayoutInflater.from(context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(products[position])
    }

    override fun getItemCount(): Int = products.size


}