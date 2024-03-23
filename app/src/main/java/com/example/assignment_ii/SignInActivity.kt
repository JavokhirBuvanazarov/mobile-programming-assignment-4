package com.example.assignment_ii

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val nameEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val signInButton = findViewById<Button>(R.id.signInButton)
        val createAccountButton = findViewById<Button>(R.id.redirectButton)

        sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)

        signInButton.setOnClickListener {
            val savedName = sharedPreferences.getString("name", "")
            val savedUserName = sharedPreferences.getString("userName", "")
            val savedPassword = sharedPreferences.getString("password", "")

            val enteredName = nameEditText.text.toString().trim()
            val enteredPassword = passwordEditText.text.toString().trim()

            if (enteredName == savedUserName && enteredPassword == savedPassword) {
                startActivity(Intent(this, CategoryActivity::class.java))
                finish() // Finish current activity
            } else {
                // Display error message for incorrect credentials
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }

        createAccountButton.setOnClickListener {
            startActivity(Intent(this, AccountCreationActivity::class.java))
        }
    }
}
