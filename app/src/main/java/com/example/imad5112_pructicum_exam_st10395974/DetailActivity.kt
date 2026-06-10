package com.example.imad5112_pructicum_exam_st10395974

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val txtFullDetails = findViewById<TextView>(R.id.txtFullDetails)
        val btnBack = findViewById<Button>(R.id.btnBack)

        val itemNames = intent.getStringArrayListExtra("ITEM_NAMES")
        val categories = intent.getStringArrayListExtra("CATEGORIES")
        val quantities = intent.getIntegerArrayListExtra("QUANTITIES")
        val comments = intent.getStringArrayListExtra("COMMENTS")

        var fullDetails = ""

        if (itemNames != null && categories != null && quantities != null && comments != null) {
            for (i in itemNames.indices) {
                fullDetails += "Item: ${itemNames[i]}\n"
                fullDetails += "Category: ${categories[i]}\n"
                fullDetails += "Quantity: ${quantities[i]}\n"
                fullDetails += "Comments: ${comments[i]}\n\n"
            }
        }

        txtFullDetails.text = fullDetails

        btnBack.setOnClickListener {
            finish()
        }
    }
}