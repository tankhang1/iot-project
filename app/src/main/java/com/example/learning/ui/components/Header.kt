package com.example.learning.ui.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.withStyledAttributes
import com.example.learning.R

class Header @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {
    private val label: TextView
    private val header_left_button: ImageView

    init {
        LayoutInflater.from(context).inflate(R.layout.fragment_header, this, true)
        header_left_button = findViewById(R.id.header_left_button)
        label = findViewById(R.id.header_label)

        header_left_button.isClickable = true
        header_left_button.isFocusable = true
        header_left_button.setOnClickListener {
            performClick()
        }
        context.withStyledAttributes(attrs,R.styleable.Header){
            label.text=getString(R.styleable.Header_text)
            label.setTextColor(getColor(R.styleable.Header_color,label.currentTextColor))
            label.textSize=getDimension(R.styleable.Header_textSize,label.textSize)
        }
    }



    override fun performClick(): Boolean {
        return super.performClick()
    }
}