package com.example.retoapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class VerificationActivity : AppCompatActivity() {
    private lateinit var tvName:TextView
    private lateinit var etNum1:EditText
    private lateinit var etNum2:EditText
    private lateinit var etNum3:EditText
    private lateinit var etNum4:EditText
    private lateinit var etNum5:EditText
    private lateinit var btnNext:Button
    private lateinit var name:String
    private lateinit var amount:String
    private lateinit var code:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)

         name = intent.getStringExtra("NAME").toString()
         amount = intent.getStringExtra("AMOUNT").toString()
         code = intent.getStringExtra("CODE").toString()

        tvName = findViewById(R.id.name)
        etNum1 = findViewById(R.id.EtNum1)
        etNum2 = findViewById(R.id.EtNum2)
        etNum3 = findViewById(R.id.EtNum3)
        etNum4 = findViewById(R.id.EtNum4)
        etNum5 = findViewById(R.id.EtNum5)
        btnNext = findViewById(R.id.btnNext)


        btnNext.setOnClickListener { validateCode() }
        initUI()
    }

    private fun validateCode() {

       var fullCode = etNum1.text.toString() +
                etNum2.text.toString() +
                etNum3.text.toString() +
                etNum4.text.toString() +
                etNum5.text.toString()

        if (code == fullCode){
            val intent = Intent(this,HomeActivity::class.java)
            intent.putExtra("NAME",name)
            intent.putExtra("AMOUNT",amount)
            startActivity(intent)
        }else{
            Toast.makeText(this, "The code is not correct", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initUI() {
        tvName.text = name
    }
}