package com.example.fetchrewards

import android.content.Context
import android.graphics.Canvas
import androidx.appcompat.widget.AppCompatTextView
import android.util.AttributeSet

class CustomTextView : AppCompatTextView {
    constructor(context: Context) : super(context) {
        this.textSize = 22f
        this.setPadding(0,0,350,0)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        this.textSize = 22f
        this.setPadding(0,0,350,0)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        this.textSize = 22f
        this.setPadding(0,0,350,0)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
    }
}