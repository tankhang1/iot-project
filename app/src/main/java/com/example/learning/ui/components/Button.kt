package com.example.learning.ui.components

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.withStyledAttributes
import com.example.learning.R

/**
 * A simple [Fragment] subclass.
 * Use the [Button.newInstance] factory method to
 * create an instance of this fragment.
 */
class Button @JvmOverloads constructor(
    context:Context,
    attrs: AttributeSet?=null
):LinearLayout(context,attrs){
    private val textView:TextView
    private val buttonContainer: LinearLayout

    init {
        LayoutInflater.from(context).inflate(R.layout.fragment_button,this,true)
        textView= findViewById(R.id.button_text)
        buttonContainer=findViewById(R.id.button_container)

        buttonContainer.isClickable=true
        buttonContainer.isFocusable=true
        buttonContainer.setOnClickListener {
            performClick() // Trigger parent click
        }
        context.withStyledAttributes(attrs,R.styleable.Button){
            textView.text= getString(R.styleable.Button_text);
            textView.setTextColor(getColor(R.styleable.Button_color,textView.currentTextColor))
            textView.textSize= getDimension(R.styleable.Button_textSize,textView.textSize)
        }
    }

    override fun performClick(): Boolean {
        // Optional: log to verify
        Log.d("CustomButton", "performClick() triggered")
        return super.performClick()
    }
}