package com.example.suma2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMultiplication = findViewById<Button>(R.id.btnMultiplication)
        val btnDivision = findViewById<Button>(R.id.btnDivision)
        val btnAddition = findViewById<Button>(R.id.btnAddition)

        btnMultiplication.setOnClickListener() { navigateToMultiplication() }
        btnDivision.setOnClickListener() { navigateToDivision() }
        btnAddition.setOnClickListener() { navigateToAddition() }

    }

    fun navigateToMultiplication() {
        // val intent = Intent(this, MultiplicationActivity::class.java)
        startActivity(intent)
    }

    fun navigateToDivision() {
        //val intent = Intent(this, DivisionActivity::class.java)
        startActivity(intent)
    }

    fun navigateToAddition() {
        val intent = Intent(this, AdditionActivity::class.java)
        startActivity(intent)
    }
}