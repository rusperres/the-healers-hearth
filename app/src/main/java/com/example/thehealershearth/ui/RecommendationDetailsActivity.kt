package com.example.thehealershearth.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.thehealershearth.R

class RecommendationDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommendation_details)
        val name = intent.getStringExtra("name")
        val icon = intent.getIntExtra("icon", 0)

        if (!name.isNullOrEmpty()) {
            findViewById<android.widget.TextView>(R.id.recommendationName).text = name
        }
        if (icon != 0) {
            val imgView = findViewById<android.widget.ImageView>(R.id.recommendationImage)
            imgView.setImageResource(icon)
            imgView.imageTintList = null
        }

        findViewById<android.widget.ImageView>(R.id.backButton).setOnClickListener {
            finish()
        }

        findViewById<android.widget.Button>(R.id.orderButton).setOnClickListener {
            val title =
                findViewById<android.widget.TextView>(R.id.recommendationName).text.toString()
            val intent = android.content.Intent(this, OrderPickupActivity::class.java)
            intent.putExtra("brewName", title)
            intent.putStringArrayListExtra(
                "ingredients",
                arrayListOf("Coffee Bean", "Medicinal Herbs")
            )
            intent.addFlags(android.content.Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }
    }
}