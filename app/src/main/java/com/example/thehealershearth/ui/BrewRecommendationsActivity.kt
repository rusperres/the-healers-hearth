package com.example.thehealershearth.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thehealershearth.R

class BrewRecommendationsActivity : AppCompatActivity() {

    val mockData = listOf(
        Triple("Elixir", "Vitalizing brew", R.drawable.ic_recommend_elixer),
        Triple("Healing Tea", "Restores energy", R.drawable.ic_recommend_healing_tea),
        Triple("Mana Potion", "Boosts magic", R.drawable.ic_recommend_mana_potion),
        Triple("Stamina Brew", "Long lasting energy", R.drawable.ic_recommend_stamina_brew),
        Triple("Sleep Aid", "Helps drift to calm slumbers", R.drawable.ic_recommend_sleep_aid),
        Triple("Focus Brew", "Enhances mental clarity", R.drawable.ic_recommend_focus_brew)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brew_recommendations)

        findViewById<android.view.View>(android.R.id.content).post {
            findViewById<android.widget.TextView>(R.id.titleGrimoire)?.text = "Brew Recommendations"
            val iconResId = resources.getIdentifier("ic_recommend", "drawable", packageName)
            if (iconResId != 0) findViewById<android.widget.ImageView>(R.id.grimoireIcon)?.setImageResource(iconResId)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recommendationsRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)


        val adapter = object : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
            override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): RecyclerView.ViewHolder {
                val view = android.view.LayoutInflater.from(parent.context).inflate(R.layout.item_recommendation_card, parent, false)
                return object : RecyclerView.ViewHolder(view) {}
            }
            override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                val item = mockData[position]
                holder.itemView.findViewById<android.widget.TextView>(R.id.recommendationTitle).text = item.first
                holder.itemView.findViewById<android.widget.TextView>(R.id.recommendationDesc).text = item.second
                val imgView = holder.itemView.findViewById<android.widget.ImageView>(R.id.recommendationImage)
                imgView.setImageResource(item.third)
                imgView.imageTintList = null
                holder.itemView.findViewById<android.widget.Button>(R.id.recommendationButton).setOnClickListener {
                    val intent = android.content.Intent(this@BrewRecommendationsActivity, RecommendationDetailsActivity::class.java)
                    intent.putExtra("name", item.first)
                    intent.putExtra("icon", item.third)
                    intent.addFlags(android.content.Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    startActivity(intent)
                    overridePendingTransition(0, 0)
                }
            }
            override fun getItemCount() = mockData.size
        }
        recyclerView.adapter = adapter
    }
}
