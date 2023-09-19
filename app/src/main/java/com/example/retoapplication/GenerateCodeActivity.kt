package com.example.retoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class GenerateCodeActivity : AppCompatActivity() {
    private lateinit var tvCode:TextView
    private lateinit var tvCont:TextView
    private lateinit var btnNext:Button
    var second:Long = 10 * 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generate_code)
        tvCode = findViewById(R.id.tvText2)
        tvCont = findViewById(R.id.tvText4)
        btnNext = findViewById(R.id.button)
        tvCode.text = generateRandomNumber()
        regressiveCount()
        btnNext.setOnClickListener {changeView()}
    }

    fun generateRandomNumber(): String {
        val randomNumber = Random.nextInt(10000, 100000)
        return String.format("%05d", randomNumber)
    }
    private fun regressiveCount() {
        tvCont.text = (second /1000).toString()
        var countDownTimer = object : CountDownTimer(second, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                tvCont.text = (millisUntilFinished /1000).toString() + "s"
            }

            override fun onFinish() {
                tvCode.text = generateRandomNumber()
                regressiveCount()
            }
        }
        countDownTimer.start()
    }
    private fun changeView(){

            val intent = Intent(this,RegisterActivity::class.java)
            intent.putExtra("EXTRA_CODE", tvCode.toString())
            startActivity(intent)

    }

}