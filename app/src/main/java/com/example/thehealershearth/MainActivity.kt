package com.example.thehealershearth

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.thehealershearth.ui.LoginActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Redirect directly to Login for authentication
        startActivity(Intent(this, LoginActivity::class.java))

        // Close MainActivity so it doesn't stay in back stack
        finish()
    }
}