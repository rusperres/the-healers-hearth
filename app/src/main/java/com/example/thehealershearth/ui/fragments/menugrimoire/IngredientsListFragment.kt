package com.example.thehealershearth.ui.fragments.menugrimoire

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thehealershearth.R
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thehealershearth.adapter.IngredientAdapter
import com.example.thehealershearth.model.Ingredient

class IngredientsListFragment: Fragment(R.layout.fragment_ingredient_list) {



    private lateinit var recyclerView: RecyclerView
    val ingredients = listOf(
        Ingredient("Coffee Bean", R.drawable.ic_ingredient_coffee_bean),
        Ingredient("Milk", R.drawable.ic_ingredient_milk),
        Ingredient("Sugar", R.drawable.ic_ingredient_sugar),
        Ingredient("Biscoff", R.drawable.ic_ingredient_biscoff),
        Ingredient("Matcha", R.drawable.ic_ingredient_matcha)
    )


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById<RecyclerView>(R.id.ingredientsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = IngredientAdapter(ingredients);
    }


}