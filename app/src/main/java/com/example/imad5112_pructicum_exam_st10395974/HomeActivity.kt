package com.example.imad5112_pructicum_exam_st10395974

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    // Parallel Arrays
    private val itemNames = ArrayList<String>()
    private val categories = ArrayList<String>()
    private val quantities = ArrayList<Int>()
    private val comments = ArrayList<String>()

    private lateinit var edtItemName: EditText
    private lateinit var edtCategory: EditText
    private lateinit var edtQuantity: EditText
    private lateinit var edtComments: EditText

    private lateinit var txtTotalItems: TextView
    private lateinit var txtItems: TextView

    private lateinit var btnAddItem: Button
    private lateinit var btnViewDetails: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Link Components
        edtItemName = findViewById(R.id.edtItemName)
        edtCategory = findViewById(R.id.edtCategory)
        edtQuantity = findViewById(R.id.edtQuantity)
        edtComments = findViewById(R.id.edtComments)

        txtTotalItems = findViewById(R.id.txtTotalItems)
        txtItems = findViewById(R.id.txtItems)

        btnAddItem = findViewById(R.id.btnAddItem)
        btnViewDetails = findViewById(R.id.btnViewDetails)

        // Sample Data
        if (itemNames.isEmpty()) {
            initializeData()
        }

        // Display Existing Data
        displayItems()
        calculateTotalItems()

        btnAddItem.setOnClickListener {
            addItem()
        }

        btnViewDetails.setOnClickListener {
            if (itemNames.isEmpty()) {
                Toast.makeText(this, "No items to view", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, DetailActivity::class.java)
                intent.putStringArrayListExtra("ITEM_NAMES", itemNames)
                intent.putStringArrayListExtra("CATEGORIES", categories)
                intent.putIntegerArrayListExtra("QUANTITIES", quantities)
                intent.putStringArrayListExtra("COMMENTS", comments)
                startActivity(intent)
            }
        }
    }

    private fun initializeData() {
        itemNames.add("Tent")
        categories.add("Shelter")
        quantities.add(1)
        comments.add("4-person Waterproof tent")

        itemNames.add("Marshmallows")
        categories.add("Food")
        quantities.add(3)
        comments.add("For S'mores")

        itemNames.add("Flashlight")
        categories.add("Safety")
        quantities.add(2)
        comments.add("Check batteries before use")

        itemNames.add("Sleeping Bag")
        categories.add("Sleeping")
        quantities.add(2)
        comments.add("Warm and comfortable")

        itemNames.add("Water Bottle")
        categories.add("Hydration")
        quantities.add(3)
        comments.add("Filled before trip")
    }

    private fun addItem() {
        val itemName = edtItemName.text.toString().trim()
        val category = edtCategory.text.toString().trim()
        val quantityText = edtQuantity.text.toString().trim()
        val comment = edtComments.text.toString().trim()

        if (itemName.isEmpty() || category.isEmpty() || quantityText.isEmpty() || comment.isEmpty()) {
            Toast.makeText(this, "Please complete all fields", Toast.LENGTH_SHORT).show()
            return
        }

        val quantity = quantityText.toIntOrNull()
        if (quantity == null) {
            Toast.makeText(this, "Please enter a valid number for quantity", Toast.LENGTH_SHORT).show()
            return
        }

        itemNames.add(itemName)
        categories.add(category)
        quantities.add(quantity)
        comments.add(comment)

        displayItems()
        calculateTotalItems()
        clearFields()

        Toast.makeText(this, "Item Added Successfully", Toast.LENGTH_SHORT).show()
    }

    private fun calculateTotalItems() {
        var total = 0
        for (q in quantities) {
            total += q
        }
        txtTotalItems.text = "Total Items Packed: $total"
    }

    private fun displayItems() {
        var output = ""
        for (i in itemNames.indices) {
            output += "Item: ${itemNames[i]}\n"
            output += "Category: ${categories[i]}\n"
            output += "Quantity: ${quantities[i]}\n\n"
        }
        txtItems.text = if (output.isEmpty()) "Items will appear here" else output
    }

    private fun clearFields() {
        edtItemName.text.clear()
        edtCategory.text.clear()
        edtQuantity.text.clear()
        edtComments.text.clear()
    }
}