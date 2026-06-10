package com.example.imad5112_pructicum_exam_st10395974

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Wait 3 seconds then open HomeActivity
        Handler(Looper.getMainLooper()).postDelayed({

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

            // Prevent user from returning to splash screen
            finish()

        }, 3000) // 3000 milliseconds = 3 seconds
    }
}