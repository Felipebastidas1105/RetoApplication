package com.example.retoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class GenerateCodeActivity : AppCompatActivity() {
    private lateinit var tvCode: TextView
    private lateinit var tvCont: TextView
    private lateinit var btnNext: Button
    private var countDownTimer: CountDownTimer? = null
    private val initialCount: Long = 10
    private var remainingCount: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generate_code)
        tvCode = findViewById(R.id.tvText2)
        tvCont = findViewById(R.id.tvText4)
        btnNext = findViewById(R.id.button)
        btnNext.setOnClickListener { changeView() }
    }

    private fun generateRandomNumber(): String {
        val randomNumber = Random.nextInt(10000, 100000)
        return String.format("%05d", randomNumber)
    }

    private fun startCountdown() {
        countDownTimer = object : CountDownTimer(remainingCount * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                remainingCount = millisUntilFinished / 1000
                tvCont.text = "$remainingCount s"
            }

            override fun onFinish() {
                tvCode.text = generateRandomNumber()
                countDownTimer?.start()

            }
        }
        countDownTimer?.start()
    }

    private fun stopCountdown() {
        countDownTimer?.cancel()
    }

    private fun changeView() {
        stopCountdown()
        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra("EXTRA_CODE", tvCode.text.toString())
        startActivity(intent)
    }


    override fun onBackPressed() {
        stopCountdown()
        finishAffinity()
    }

    override fun onResume() {
        super.onResume()
        tvCode.text = generateRandomNumber()
        remainingCount = initialCount
        tvCont.text = "$remainingCount s"
        startCountdown()
    }

    override fun onPause() {
        super.onPause()
        stopCountdown()
    }
}
