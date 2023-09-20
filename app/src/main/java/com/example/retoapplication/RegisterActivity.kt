package com.example.retoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {
    private lateinit var etName:TextInputEditText
    private lateinit var etAmount:TextInputEditText
    private lateinit var btnNext:Button

    override fun onCreate(savedInstanceState: Bundle??) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var code = intent.getStringExtra("EXTRA_CODE").toString()
        etName = findViewById(R.id.EtFullName)
        etAmount = findViewById(R.id.EtInitialAmount)
        btnNext = findViewById(R.id.button)
        btnNext.setOnClickListener { changeView(code) }
    }

    private fun changeView(code:String) {
        val intent = Intent(this, VerificationActivity::class.java)
        intent.putExtra("NAME", etName.text.toString())
        intent.putExtra("AMOUNT",etAmount.text.toString())
        intent.putExtra("CODE",code)
        startActivity(intent)
    }


}

