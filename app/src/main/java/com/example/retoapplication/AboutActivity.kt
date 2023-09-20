package com.example.retoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AboutActivity : AppCompatActivity() {
    private lateinit var btnNext:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        btnNext = findViewById(R.id.button)

        btnNext.setOnClickListener {
            cambioVista()
        }
    }
    private fun cambioVista() {
        val intent = Intent(this,GenerateCodeActivity::class.java)
        startActivity(intent)
    }
    override fun onBackPressed() {
        finishAffinity()
    }
}