package com.example.fetchrewards

import android.content.Context
import android.graphics.Canvas
import androidx.appcompat.widget.AppCompatTextView
import android.util.AttributeSet
import android.widget.TableRow

class CustomTableRow : TableRow {
    constructor(context: Context) : super(context) {
        this.setPadding(0,0,0,20)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        this.setPadding(0,0,0,20)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
    }
}