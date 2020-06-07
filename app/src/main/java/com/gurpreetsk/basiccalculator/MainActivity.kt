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
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate
        setContentView(R.layout.activity_main)

        // Get view handles
        val addButton = findViewById<Button>(R.id.addButton)
        val subtractButton = findViewById<Button>(R.id.subtractButton)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val divisionButton = findViewById<Button>(R.id.divisionButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val firstEditText = findViewById<EditText>(R.id.firstInputEditText)
        val secondEditText = findViewById<EditText>(R.id.secondInputEditText)

        // Listen to clicks
        subtractButton.setOnClickListener {
            subtractButton(firstEditText, secondEditText, resultTextView)
        }

        divisionButton.setOnClickListener {

            val firstNumber = firstEditText.text.toString()
            val secondNumber = secondEditText.text.toString()
            if (firstNumber == "") {
                Toast.makeText(this, "please enter first number", Toast.LENGTH_SHORT).show()
            } else if (secondNumber == "") {
                Toast.makeText(this, "please enter second number ", Toast.LENGTH_SHORT).show()
            } else if(secondNumber=="0"){
                Toast.makeText(this, "infinity... enter number other than 0", Toast.LENGTH_SHORT).show() }
            else
            {val result = firstNumber.toFloat() / secondNumber.toFloat()
                resultTextView.text= result.toString()
            }
        }

        addButton.setOnClickListener {
            addTwoNumbers(firstEditText, secondEditText, resultTextView)
        }
        multiplyButton.setOnClickListener {
            multiplyButton(multiplyButton, firstEditText, secondEditText, resultTextView)
        }
    }

    private fun multiplyButton(
        multiplyButton: Button,
        firstEditText: EditText,
        secondEditText: EditText,
        resultTextView: TextView
    ) {
        multiplyButton.setOnClickListener {
            val firstnumber = firstEditText.text.toString()
            val secondnumber = secondEditText.text.toString()
            if (firstnumber == "") {
                Toast.makeText(this, "please enter first number", Toast.LENGTH_SHORT).show()
            } else if (secondnumber == "") {
                Toast.makeText(this, "please enter second number", Toast.LENGTH_SHORT).show()
            } else {
                val result = firstnumber.toInt() * secondnumber.toInt()
                resultTextView.text = result.toString()
            }
        }
    }

    private fun subtractButton(
        firstEditText: EditText,
        secondEditText: EditText,
        resultTextView: TextView
    ) {
        val firstnumber = firstEditText.text.toString()
        val secondnumber = secondEditText.text.toString()

        if (firstnumber == "") {
            Toast.makeText(this, "please enter first number", Toast.LENGTH_SHORT).show()
        } else if (secondnumber == "") {

            Toast.makeText(this, "please enter second number", Toast.LENGTH_SHORT).show()
        } else {
            val result = firstnumber.toInt() - secondnumber.toInt()
            resultTextView.text = result.toString()
        }
    }

    private fun addTwoNumbers(
        firstEditText: EditText,
        secondEditText: EditText,
        resultTextView: TextView
    ) {
        val firstNumber = firstEditText.text.toString()
        val secondNumber = secondEditText.text.toString()

        if (firstNumber == "") {
            resultTextView.text = "Please enter first input"
        } else if (secondNumber == "") {
            resultTextView.text = "Please enter second input"
        } else {
            val result = firstNumber.toInt() + secondNumber.toInt()

            resultTextView.text = result.toString()
        }
    }
}
