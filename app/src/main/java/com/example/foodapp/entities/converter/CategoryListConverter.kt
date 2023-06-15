package com.example.foodapp.entities.converter

import androidx.room.TypeConverter
import com.example.foodapp.entities.Category
import com.example.foodapp.entities.CategoryItems
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CategoryListConverter {

    @TypeConverter
    fun fromCategoryList(category: List<CategoryItems>): String? {
        val gson = Gson()
        val type = object : TypeToken<CategoryItems>() {

        }.type
        return gson.toJson(category, type)
    }

    @TypeConverter
    fun toCategoryList(categoryString: String): List<CategoryItems>? {
        val gson = Gson()
        val type = object : TypeToken<CategoryItems>() {

        }.type
        return gson.fromJson(categoryString, type)
    }
}