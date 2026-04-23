package com.example.thehealershearth.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thehealershearth.R
import com.example.thehealershearth.model.Ingredient
import com.example.thehealershearth.ui.IngredientDetailsActivity

class IngredientAdapter(
    private val items: List<Ingredient>
) : RecyclerView.Adapter<IngredientAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.findViewById(R.id.ingredientIcon)
        val name: TextView = view.findViewById(R.id.ingredientName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_ingredient, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.name.text = item.name
        holder.icon.setImageResource(item.icon)
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, IngredientDetailsActivity::class.java)
            intent.putExtra("name", item.name)
            intent.putExtra("icon", item.icon)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount() = items.size
}