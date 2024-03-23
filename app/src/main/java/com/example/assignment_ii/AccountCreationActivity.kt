package com.example.assignment_ii

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AccountCreationActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_creation)

        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val emailPhoneEditText = findViewById<EditText>(R.id.emailPhoneEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val reEnterPasswordEditText = findViewById<EditText>(R.id.reEnterPasswordEditText)
        val continueButton = findViewById<Button>(R.id.continueButton)

        sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)

        continueButton.setOnClickListener {
            val name = nameEditText.text.toString().trim() // Get the user's name
            val userName = emailPhoneEditText.text.toString().trim() // Get the user's name
            val password = passwordEditText.text.toString().trim() // Get the user's name

            val editor = sharedPreferences.edit()
            editor.putString("name", name)
            editor.putString("userName", userName)
            editor.putString("password", password)
            editor.apply()

            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
