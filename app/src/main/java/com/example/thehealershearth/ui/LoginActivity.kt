package com.example.thehealershearth.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.thehealershearth.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val email = findViewById<EditText>(R.id.etEmail)
        val password = findViewById<EditText>(R.id.etPassword)

        val loginBtn = findViewById<Button>(R.id.btnLogin)
        val forgot = findViewById<TextView>(R.id.tvForgotPassword)
        val signup = findViewById<TextView>(R.id.tvNotSignedUp)

        // LOGIN BUTTON
        loginBtn.setOnClickListener {

            val emailText = email.text.toString().trim()
            val passText = password.text.toString().trim()

            if (emailText.isEmpty() || passText.isEmpty()) {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // TEMP LOGIN LOGIC (replace later with backend)
            if (emailText == "admin" && passText == "1234") {
                Toast.makeText(this, "Welcome to the Hearth", Toast.LENGTH_SHORT).show()

                startActivity(Intent(this, MenuGrimoireActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }

        // FORGOT PASSWORD
        forgot.setOnClickListener {
            Toast.makeText(this, "Healing ritual coming soon", Toast.LENGTH_SHORT).show()
        }

        // GO TO REGISTER
        signup.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}