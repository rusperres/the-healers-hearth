package com.example.thehealershearth.ui

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.thehealershearth.R

class OrderPickupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_pickup)

        val orderButton = findViewById<Button>(R.id.orderButton)

        findViewById<android.view.View>(android.R.id.content).post {
            findViewById<android.widget.TextView>(R.id.titleGrimoire)?.text = "Order & Pickup"
            val iconResId = resources.getIdentifier("ic_order", "drawable", packageName)
            if (iconResId != 0) findViewById<android.widget.ImageView>(R.id.grimoireIcon)?.setImageResource(iconResId)
        }

        val brewName = intent.getStringExtra("brewName")
        val ingredients = intent.getStringArrayListExtra("ingredients")

        val rv = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.orderSummaryRecyclerView)
        val emptyText = findViewById<android.widget.TextView>(R.id.emptyStateText)
        val totalText = findViewById<android.widget.TextView>(R.id.totalText)

        if (brewName.isNullOrEmpty()) {
            rv.visibility = android.view.View.GONE
            emptyText.visibility = android.view.View.VISIBLE
            totalText.text = "Total: Php 0"
            orderButton.isEnabled = false
        } else {
            rv.visibility = android.view.View.VISIBLE
            emptyText.visibility = android.view.View.GONE
            totalText.text = "Total: Php 500"
            
            rv.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
            val list = mutableListOf("1x $brewName")
            ingredients?.forEach { list.add("   + $it") }

            rv.adapter = object : androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>() {
                override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): androidx.recyclerview.widget.RecyclerView.ViewHolder {
                    val tv = android.widget.TextView(this@OrderPickupActivity).apply {
                        setTextColor(android.graphics.Color.parseColor("#F2EAD3"))
                        textSize = 16f
                        setPadding(0, 8, 0, 8)
                    }
                    return object : androidx.recyclerview.widget.RecyclerView.ViewHolder(tv) {}
                }
                override fun onBindViewHolder(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, position: Int) {
                    (holder.itemView as android.widget.TextView).text = list[position]
                }
                override fun getItemCount() = list.size
            }
        }

        orderButton.setOnClickListener {
            val itemsString = buildString { 
                append("1x ")
                append(brewName)
                if (!ingredients.isNullOrEmpty()) {
                    append(" (")
                    append(ingredients.joinToString(", "))
                    append(")")
                }
            }
            com.example.thehealershearth.model.OrderStorage.addOrder(itemsString, "Php 500")
            Toast.makeText(this, "Order placed successfully!", Toast.LENGTH_SHORT).show()
        }
    }
}
