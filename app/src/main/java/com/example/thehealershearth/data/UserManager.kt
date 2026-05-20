package com.example.thehealershearth.data

import android.content.Context
import android.content.SharedPreferences
import com.example.thehealershearth.model.User

class UserManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("HearthAccounts", Context.MODE_PRIVATE)

    private val mockAccounts = mutableListOf(
        User("Archmage", "100", "admin@hearth.com", "admin123"),
        User("Apprentice", "18", "user@hearth.com", "user123"),
        User("Admin", "0", "admin", "1234") // legacy mock
    )

    fun validateUser(email: String, pass: String): Boolean {
        if (mockAccounts.any { it.email == email && it.password == pass }) return true

        val savedPass = prefs.getString(email, null)
        return savedPass == pass
    }

    fun addUser(user: User): Boolean {
        if (exists(user.email)) return false
        
        val editor = prefs.edit()
        editor.putString(user.email, user.password)
        editor.putString("${user.email}_name", user.name)
        editor.putString("${user.email}_age", user.age)
        return editor.commit()
    }

    fun exists(email: String): Boolean {
        if (mockAccounts.any { it.email == email }) return true
        return prefs.contains(email)
    }

    fun resetPassword(email: String, newPass: String): Boolean {
        if (!exists(email)) return false
        
        if (mockAccounts.any { it.email == email }) {
            val editor = prefs.edit()
            editor.putString(email, newPass)
            return editor.commit()
        }

        val editor = prefs.edit()
        editor.putString(email, newPass)
        return editor.commit()
    }
}
