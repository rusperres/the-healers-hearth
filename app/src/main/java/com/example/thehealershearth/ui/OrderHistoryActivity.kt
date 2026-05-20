package com.example.thehealershearth.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thehealershearth.R

class OrderHistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_history)

        findViewById<android.view.View>(android.R.id.content).post {
            findViewById<android.widget.TextView>(R.id.titleGrimoire)?.text = "Order History"
            val iconResId = resources.getIdentifier("ic_history", "drawable", packageName)
            if (iconResId != 0) findViewById<android.widget.ImageView>(R.id.grimoireIcon)?.setImageResource(iconResId)
        }

        val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.orderHistoryRecyclerView)
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        
        val adapter = object : androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>() {
            override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): androidx.recyclerview.widget.RecyclerView.ViewHolder {
                val view = android.view.LayoutInflater.from(parent.context).inflate(R.layout.item_order_history, parent, false)
                return object : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {}
            }
            override fun onBindViewHolder(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, position: Int) {
                val item = com.example.thehealershearth.model.OrderStorage.mockData[position]
                holder.itemView.findViewById<android.widget.TextView>(R.id.orderIdText).text = item.id
                holder.itemView.findViewById<android.widget.TextView>(R.id.orderDateText).text = item.date
                holder.itemView.findViewById<android.widget.TextView>(R.id.orderItemsText).text = item.items
                holder.itemView.findViewById<android.widget.TextView>(R.id.orderTotalText).text = item.total
            }
            override fun getItemCount() = com.example.thehealershearth.model.OrderStorage.mockData.size
        }
        recyclerView.adapter = adapter
    }
}
