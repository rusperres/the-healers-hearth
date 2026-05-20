package com.example.thehealershearth.ui

import android.os.Bundle
import android.util.Log
import android.view.View
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

        findViewById<android.view.View>(android.R.id.content).post {
            findViewById<android.widget.TextView>(R.id.titleGrimoire)?.text = "Menu Grimoire"
            val iconResId = resources.getIdentifier("ic_grimoire", "drawable", packageName)
            if (iconResId != 0) findViewById<android.widget.ImageView>(R.id.grimoireIcon)?.setImageResource(iconResId)
        }


        Log.d("GRIMOIRE", "Activity opened")

    }
}