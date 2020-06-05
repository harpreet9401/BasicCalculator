package com.gurpreetsk.basiccalculator

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate
        setContentView(R.layout.activity_main)

        // Get view handles
        val addButton = findViewById<Button>(R.id.addButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val firstEditText = findViewById<EditText>(R.id.firstInputEditText)
        val secondEditText = findViewById<EditText>(R.id.secondInputEditText)

        // Listen to clicks
        addButton.setOnClickListener {
            val firstNumber = firstEditText.text.toString()
            val secondNumber = secondEditText.text.toString()

            if (firstNumber == "") {
                resultTextView.text = "Please enter first input"
            }
            else if (secondNumber == "") {
                resultTextView.text = "Please enter second input"
            }
            else {
                val result = firstNumber.toInt() + secondNumber.toInt()

                resultTextView.text = result.toString()
            }
        }
    }
}