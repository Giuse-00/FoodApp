package com.example.foodapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.foodapp.dao.RecipeDao
import com.example.foodapp.entities.Category
import com.example.foodapp.entities.CategoryItems
import com.example.foodapp.entities.Meal
import com.example.foodapp.entities.MealsItems
import com.example.foodapp.entities.Recipes
import com.example.foodapp.entities.converter.CategoryListConverter
import com.example.foodapp.entities.converter.MealListConverter

@Database(
    entities = [Recipes::class, CategoryItems::class, Category::class, Meal::class, MealsItems::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(CategoryListConverter::class, MealListConverter::class)

abstract class RecipeDatabase : RoomDatabase() {

    companion object {

        var recipesDatabase: RecipeDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): RecipeDatabase {
            if (recipesDatabase == null) {
                recipesDatabase = Room.databaseBuilder(
                    context,
                    RecipeDatabase::class.java,
                    "recipe.db"
                ).build()
            }
            return recipesDatabase!!
        }
    }

    abstract fun recipeDao(): RecipeDao

}