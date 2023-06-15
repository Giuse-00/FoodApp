package com.example.foodapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodapp.databinding.ItemRvMainCategoryBinding
import com.example.foodapp.databinding.ItemRvSubCategoryBinding
import com.example.foodapp.entities.Meal
import com.example.foodapp.entities.MealsItems
import com.example.foodapp.entities.Recipes

class SubCategoryAdapter : RecyclerView.Adapter<SubCategoryAdapter.RecipeViewHolder>() {

    var listener: SubCategoryAdapter.OnItemClickListener? = null
    var arrSubCategory = ArrayList<MealsItems>()

    class RecipeViewHolder(private val binding: ItemRvSubCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(mealsItems: MealsItems) {
            binding.tvDishName.text = mealsItems.strMeal
            Glide.with(binding.root).load(mealsItems.strMealThumb).into(binding.imgDish)
        }
    }

    fun setData(arrData: List<MealsItems>) {
        arrSubCategory = arrData as ArrayList<MealsItems>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding =
            ItemRvSubCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return arrSubCategory.size
    }

    fun setClickListener(listener1: SubCategoryAdapter.OnItemClickListener){
        listener = listener1
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(arrSubCategory[position])

        holder.itemView.rootView.setOnClickListener {
            listener!!.onClicked(arrSubCategory[position].idMeal)
        }
    }

    interface OnItemClickListener{
        fun onClicked(id: String)
    }

}