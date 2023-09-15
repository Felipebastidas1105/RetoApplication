package com.example.retoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.cardview.widget.CardView
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    private lateinit var TvCont:TextView
    var second:Long = 5 * 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        TvCont = findViewById(R.id.tvCont)

        cuentaRegresiva()
    }

    private fun cuentaRegresiva() {
        TvCont.text = (second /1000).toString()
        var countDownTimer = object : CountDownTimer(second, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                TvCont.text = (millisUntilFinished /1000).toString()
            }

            override fun onFinish() {
                cambioVista()
            }
        }
        countDownTimer.start()
    }

    private fun cambioVista() {
        val intent = Intent(this,AboutActivity::class.java)
        startActivity(intent)
    }
}