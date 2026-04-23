package com.example.thehealershearth.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.thehealershearth.R

class IngredientDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredient_details)

        val name = intent.getStringExtra("name")
        val icon = intent.getIntExtra("icon", 0)

        findViewById<TextView>(R.id.ingredientName).text = name
        findViewById<ImageView>(R.id.ingredientImage).setImageResource(icon)
    }
}