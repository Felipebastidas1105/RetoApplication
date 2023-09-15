package com.example.retoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import kotlin.random.Random

class GenerateCodeActivity : AppCompatActivity() {
    private lateinit var tvCode:TextView
    private lateinit var tvCont:TextView
    var second:Long = 5 * 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generate_code)
        tvCode = findViewById(R.id.tvText2)
        tvCont = findViewById(R.id.tvText4)
        tvCode.text =   generarNumeroAleatorio()
        cuentaRegresiva()

    }

    fun generarNumeroAleatorio(): String {
        val numeroAleatorio = Random.nextInt(10000, 100000)
        return String.format("%05d", numeroAleatorio)
    }
    private fun cuentaRegresiva() {
        tvCont.text = (second /1000).toString()
        var countDownTimer = object : CountDownTimer(second, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                tvCont.text = (millisUntilFinished /1000).toString()
            }

            override fun onFinish() {
                generarNumeroAleatorio()
            }
        }
        countDownTimer.start()
    }
}