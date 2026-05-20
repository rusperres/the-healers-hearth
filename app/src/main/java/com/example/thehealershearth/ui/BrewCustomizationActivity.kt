package com.example.thehealershearth.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.thehealershearth.R
import com.example.thehealershearth.model.Ingredient

class BrewCustomizationActivity : AppCompatActivity() {

    val categories = listOf("Frappe", "Elixir", "Tea", "Potion")
    val ingredientChoices = listOf(
        Ingredient("Coffee Bean", R.drawable.ic_ingredient_coffee_bean),
        Ingredient("Milk", R.drawable.ic_ingredient_milk),
        Ingredient("Sugar", R.drawable.ic_ingredient_sugar),
        Ingredient("Biscoff", R.drawable.ic_ingredient_biscoff),
        Ingredient("Matcha", R.drawable.ic_ingredient_matcha)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brew_customization)

        findViewById<android.view.View>(android.R.id.content).post {
            findViewById<android.widget.TextView>(R.id.titleGrimoire)?.text = "Brew Customization"
            val iconResId = resources.getIdentifier("ic_brew", "drawable", packageName)
            if (iconResId != 0) findViewById<android.widget.ImageView>(R.id.grimoireIcon)?.setImageResource(iconResId)
        }

        val categorySpinner = findViewById<android.widget.Spinner>(R.id.categorySpinner)
        categorySpinner.adapter = android.widget.ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, categories)

        val ingredientSpinner = findViewById<android.widget.Spinner>(R.id.ingredientSpinner)
        ingredientSpinner.adapter = android.widget.ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, ingredientChoices.map { it.name })
        
        val ingredientsList = mutableListOf<Ingredient>()
        val rv = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.ingredientsRecyclerView)
        rv.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        
        val adapter = object : androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>() {
            override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): androidx.recyclerview.widget.RecyclerView.ViewHolder {
                val view = android.view.LayoutInflater.from(parent.context).inflate(R.layout.item_ingredient, parent, false)
                return object : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {}
            }
            override fun onBindViewHolder(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, position: Int) {
                val item = ingredientsList[position]
                holder.itemView.findViewById<android.widget.TextView>(R.id.ingredientName).text = item.name
                holder.itemView.findViewById<android.widget.ImageView>(R.id.ingredientIcon).apply {
                    setImageResource(item.icon)
                    imageTintList = null
                }
            }
            override fun getItemCount() = ingredientsList.size
        }
        rv.adapter = adapter

        findViewById<Button>(R.id.addIngredientButton).setOnClickListener {
            val selectedIdx = ingredientSpinner.selectedItemPosition
            val selectedItem = ingredientChoices[selectedIdx]
            ingredientsList.add(selectedItem)
            adapter.notifyItemInserted(ingredientsList.size - 1)
        }

        val orderButton = findViewById<Button>(R.id.orderButton)
        orderButton.setOnClickListener {
            if (ingredientsList.isEmpty()) {
                android.widget.Toast.makeText(this, "Please add at least one ingredient!", android.widget.Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(this, OrderPickupActivity::class.java)
            intent.putExtra("brewName", "Custom " + categorySpinner.selectedItem.toString())
            intent.putStringArrayListExtra("ingredients", ArrayList(ingredientsList.map { it.name }))
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }
    }
}
