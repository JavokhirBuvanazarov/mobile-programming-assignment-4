package com.example.assignment_ii

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val showPasswordCheckBox = findViewById<CheckBox>(R.id.showPasswordCheckBox)
        val signInButton = findViewById<Button>(R.id.signInButton)
        val createAccountButton = findViewById<Button>(R.id.redirectButton)

        showPasswordCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                passwordEditText.inputType = 129
            } else {
                passwordEditText.inputType = 128
            }
        }

        signInButton.setOnClickListener {
            // Placeholder for sign-in logic
            startActivity(Intent(this, CategoryActivity::class.java))
        }

        createAccountButton.setOnClickListener {
            startActivity(Intent(this, AccountCreationActivity::class.java))
        }
    }
}
