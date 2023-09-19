package com.example.widgetexploration

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.CheckBox

import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextClock
import android.widget.TextView


//import kotlinx.android.synthetic.main.exploration_layout.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exploration_layout)

        //radio buttons attributes
        val rdGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val btnGrLondon = findViewById<RadioButton>(R.id.radioButtonLondon)
        val btnGrBeijing = findViewById<RadioButton>(R.id.radioButtonBeijing)
        val btnGrNewYork = findViewById<RadioButton>(R.id.radioButtonNewYork)
        val btnGrEurope = findViewById<RadioButton>(R.id.radioButtonEurope)

        //check box attributes
        val chkTransparency  = findViewById<CheckBox>(R.id.checkBoxTransparency)
        val chkResize  = findViewById<CheckBox>(R.id.checkBoxResize)
        val chkTint  = findViewById<CheckBox>(R.id.checkBoxTint)

        //image View
        val imageView = findViewById<ImageView>(R.id.imageView)

        //button
        val btn = findViewById<Button>(R.id.button)
        //switch button
        val switch = findViewById<Switch>(R.id.switch1)
        //text view
        val text = findViewById<TextView>(R.id.textView)

        //edit text
        val editText = findViewById<EditText>(R.id.editText)
        //text clock
        val textClock = findViewById<TextClock>(R.id.textClock)


        //changing transparency of the image
        chkTransparency.setOnCheckedChangeListener { view, isChecked ->
            if (isChecked) {
                //set some transparency
                imageView.alpha = .1f
            } else {
                //remove the transparency
                imageView.alpha = 1f
            }
        }

        //changing color using tint
        chkTint.setOnCheckedChangeListener { view, isChecked ->
            if (isChecked) {
                //checked thus set color tint
                imageView.setColorFilter(Color.argb(150, 255, 0, 0))
            } else {
                //no tint needed
                imageView.setColorFilter(Color.argb(0, 0, 0, 0))
            }
        }

        //changing size of image using resize
        chkResize.setOnCheckedChangeListener { view, isChecked ->
            if (isChecked) {
                imageView.scaleX = 2f
                imageView.scaleY = 2f
            } else {
                //not checked thus regular size
                imageView.scaleX = 1f
                imageView.scaleY = 1f
            }
        }

        //handling the radio buttons and radio group
        rdGroup.clearCheck()

        rdGroup.setOnCheckedChangeListener{
            group, checkedId ->
            val rb = group.findViewById<View>(checkedId) as RadioButton

            when(rb.id) {
                R.id.radioButtonLondon ->
                    textClock.timeZone = "Europe/London"

                R.id.radioButtonBeijing ->
                    textClock.timeZone = "CST6CDT"

                R.id.radioButtonNewYork ->
                    textClock.timeZone = "America/NewYork"

                R.id.radioButtonEurope ->
                    textClock.timeZone = "Europe/Brussels"

            }
        }


            //handling the button and the edit text field
        btn.setOnClickListener {
            text.text =editText.text
        }

        //handling the switch widget
        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                text.visibility = View.VISIBLE
            }else{
                text.visibility = View.INVISIBLE
            }
        }

    }
}