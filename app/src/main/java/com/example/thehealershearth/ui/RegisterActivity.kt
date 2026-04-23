package com.example.thehealershearth.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.thehealershearth.R

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val name = findViewById<EditText>(R.id.etName)
        val age = findViewById<EditText>(R.id.etAge)
        val email = findViewById<EditText>(R.id.etEmail)
        val password = findViewById<EditText>(R.id.etPassword)
        val confirm = findViewById<EditText>(R.id.etConfirm)

        val registerBtn = findViewById<Button>(R.id.btnRegister)
        val loginLink = findViewById<TextView>(R.id.tvAlreadyAccount)

        registerBtn.setOnClickListener {

            val n = name.text.toString().trim()
            val a = age.text.toString().trim()
            val e = email.text.toString().trim()
            val p = password.text.toString().trim()
            val c = confirm.text.toString().trim()

            if (n.isEmpty() || a.isEmpty() || e.isEmpty() || p.isEmpty() || c.isEmpty()) {
                Toast.makeText(this, "Complete all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (p != c) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // TEMP REGISTER LOGIC
            Toast.makeText(this, "Welcome, $n", Toast.LENGTH_SHORT).show()

            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        loginLink.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}