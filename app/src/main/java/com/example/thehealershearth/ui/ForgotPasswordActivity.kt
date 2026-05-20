package com.example.thehealershearth.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.thehealershearth.R
import com.example.thehealershearth.data.UserManager

class ForgotPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forgotpassword_layout)

        val email = findViewById<EditText>(R.id.etEmail)
        val code = findViewById<EditText>(R.id.etCode)
        val sendCode = findViewById<Button>(R.id.btnSendCode)
        val back = findViewById<TextView>(R.id.btnBack)

        val userManager = UserManager(this)

        sendCode.setOnClickListener {
            val emailText = email.text.toString().trim()
            if (emailText.isEmpty()) {
                Toast.makeText(this, "Enter email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (userManager.exists(emailText)) {
                Toast.makeText(this, "A restorative ritual (code) has been sent to your spiritual inbox", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "No healer found with this email", Toast.LENGTH_SHORT).show()
            }
        }

        back.setOnClickListener {
            finish()
        }
    }
}
