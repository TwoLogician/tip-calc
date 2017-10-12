package com.softveloper.tipcalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var billEditText: EditText
    private lateinit var fifteenButton: Button
    private lateinit var tenButton: Button
    private lateinit var tipTextView: TextView
    private lateinit var totalTextView: TextView
    private lateinit var twentyButton: Button

    private val fifteenButtonClick = View.OnClickListener {
        setTipAndTotal(15)
    }

    private val tenButtonClick = View.OnClickListener {
        setTipAndTotal(10)
    }

    private val twentyButtonClick = View.OnClickListener {
        setTipAndTotal(20)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        billEditText = findViewById(R.id.billEditText) as EditText
        fifteenButton = findViewById(R.id.fifteenButton) as Button
        tenButton = findViewById(R.id.tenButton) as Button
        tipTextView = findViewById(R.id.tipTextView) as TextView
        totalTextView = findViewById(R.id.totalTextView) as TextView
        twentyButton = findViewById(R.id.twentyButton) as Button

        fifteenButton.setOnClickListener(fifteenButtonClick)
        tenButton.setOnClickListener(tenButtonClick)
        twentyButton.setOnClickListener(twentyButtonClick)
    }

    private fun setTipAndTotal(percentage: Int) {
        val bill = billEditText.text.toString().toDouble()
        val tip = bill / 100 * percentage
        val total = bill - tip
        tipTextView.text = "Tip - $${String.format("%.2f", tip)}"
        totalTextView.text = "Total - $${String.format("%.2f", total)}"
    }
}
