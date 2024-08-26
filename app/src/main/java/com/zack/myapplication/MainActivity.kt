package com.zack.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var userInput : EditText
        lateinit var passwdInput : EditText
        lateinit var btnLogin : Button

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        userInput = findViewById(R.id.user)
        passwdInput = findViewById(R.id.pwd)
        btnLogin=findViewById(R.id.btnlogin)

        btnLogin.setOnClickListener {
            val username = userInput.text.toString()
            val pw = passwdInput.text.toString()

            if (username == "admin" && pw == "12345") {
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("EXTRA_MESSAGE", "Hello from MainActivity")
                startActivity(intent)

            } else {
                Toast.makeText(this, "username dan password yang di inputkan salah", Toast.LENGTH_SHORT).show()
            }
        }

    }
}