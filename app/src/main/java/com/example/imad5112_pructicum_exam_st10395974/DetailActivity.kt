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
        val txtPackingTip = findViewById<TextView>(R.id.txtPackingTip)
        val btnBack = findViewById<Button>(R.id.btnBack)

        val itemNames = intent.getStringArrayListExtra("ITEM_NAMES")
        val categories = intent.getStringArrayListExtra("CATEGORIES")
        val quantities = intent.getIntegerArrayListExtra("QUANTITIES")
        val comments = intent.getStringArrayListExtra("COMMENTS")

        if (itemNames != null && categories != null && quantities != null && comments != null) {
            // Build creative 'Explorers Log' style text
            val logBuilder = StringBuilder()
            logBuilder.append(" CAMPING LOG\n")
            logBuilder.append("━━━━━━━━━━━━━━━━━━━━━\n\n")

            for (i in itemNames.indices) {
                logBuilder.append(" ${itemNames[i].uppercase()}\n")
                logBuilder.append("   Category: ${categories[i]}\n")
                logBuilder.append("   Qty: x${quantities[i]}\n")
                logBuilder.append("   Note: \"${comments[i]}\"\n")
                logBuilder.append("─────────────────────\n\n")
            }
            
            txtFullDetails.text = logBuilder.toString()
            
            // Set dynamic wisdom tip
            txtPackingTip.text = getCampsiteWisdom(categories)
        } else {
            txtFullDetails.text = "The gear bag is empty. Time to pack for your next adventure!"
            txtPackingTip.text = "Tip: Preparation is the key to a safe trip."
        }

        btnBack.setOnClickListener { finish() }
    }

    private fun getCampsiteWisdom(categories: List<String>): String {
        val lowCats = categories.map { it.lowercase() }
        return when {
            lowCats.any { it.contains("shelter") || it.contains("tent") } -> getString(R.string.tip_shelter)
            lowCats.any { it.contains("sleep") || it.contains("bag") } -> getString(R.string.tip_sleeping)
            lowCats.any { it.contains("water") || it.contains("drink") } -> getString(R.string.tip_hydration)
            else -> getString(R.string.tip_general)
        }
    }
}