package com.example.myquatsapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class splesh : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splesh)


            val spleshDuration = 2000L

            Thread{
                Thread.sleep(spleshDuration)
                startActivity(Intent(this@splesh,MainActivity::class.java))
                finish()

        }.start()
    }
}