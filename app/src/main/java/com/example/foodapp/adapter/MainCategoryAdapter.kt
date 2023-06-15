package com.example.foodapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodapp.R
import com.example.foodapp.databinding.ItemRvMainCategoryBinding
import com.example.foodapp.entities.CategoryItems
import com.example.foodapp.entities.Recipes

class MainCategoryAdapter : RecyclerView.Adapter<MainCategoryAdapter.RecipeViewHolder>() {

    var listener: OnItemClickListener? = null
    var arrMainCategory = ArrayList<CategoryItems>()

    class RecipeViewHolder(private val binding: ItemRvMainCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(categoryItems: CategoryItems) {
            binding.tvDishName.text = categoryItems.strCategory
            Glide.with(binding.root).load(categoryItems.strCategoryThumb).into(binding.imgDish)
        }
    }

    fun setData(arrData: List<CategoryItems>) {
        arrMainCategory = arrData as ArrayList<CategoryItems>
    }

    fun setClickListener(listener1: OnItemClickListener){
        listener = listener1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding =
            ItemRvMainCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return arrMainCategory.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(arrMainCategory[position])
        holder.itemView.rootView.setOnClickListener {
            listener!!.onClicked(arrMainCategory[position].strCategory)
        }
    }

    interface OnItemClickListener{
        fun onClicked(categoryName: String)
    }
}