package com.example.assignment_ii

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CategoryActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)
        val userName = sharedPreferences.getString("name", "Guest") ?: "Guest" // Default value "Guest" if user name is not found

        val welcomeTextView = findViewById<TextView>(R.id.welcomeTextView)
        welcomeTextView.text = "Welcome, $userName"
    }
}