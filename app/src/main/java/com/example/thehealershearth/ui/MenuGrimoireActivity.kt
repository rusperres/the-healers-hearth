package com.example.thehealershearth.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thehealershearth.R
import com.example.thehealershearth.adapter.IngredientAdapter
import com.example.thehealershearth.model.Ingredient

class MenuGrimoireActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_grimoire)

        val recyclerView = findViewById<RecyclerView>(R.id.ingredientsRecyclerView)

        val ingredients = listOf(
            Ingredient("Chamomile", R.drawable.ic_ingredient_placeholder),
            Ingredient("Mint", R.drawable.ic_ingredient_placeholder),
            Ingredient("Lavender", R.drawable.ic_ingredient_placeholder)
        )
        Log.d("GRIMOIRE", "Activity opened")

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = IngredientAdapter(ingredients)
    }
}