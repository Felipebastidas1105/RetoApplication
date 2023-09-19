package com.example.retoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {
    private lateinit var etName:EditText
    private lateinit var etAmount:EditText
    private lateinit var btnNext:Button
    private var extras = intent.extras
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        etName = findViewById(R.id.EtFullName)
        etAmount = findViewById(R.id.EtInitialAmount)
        btnNext =  findViewById(R.id.button)

        btnNext.setOnClickListener { changeView() }
    }

    private fun changeView() {
        val intent = Intent(this,VerificationActivity::class.java)
        intent.putExtra("Name",etName.toString())
        intent.putExtra("Amount",etName.toString())
        intent.putExtra("Code",extras)
    }

}