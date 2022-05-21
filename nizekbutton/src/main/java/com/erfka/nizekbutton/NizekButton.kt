package com.erfka.nizekbutton

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.ImageViewCompat

class NizekButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.nizekButtonStyle
) : ConstraintLayout(context, attrs, defStyleAttr) {

//class NizekButton : ConstraintLayout {

    private var manager: DrawManager? = null

//    constructor(context: Context) : super(context) {
//        bind(null, 0)
//    }
//
//    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
//        bind(attrs, 0)
//    }
//
//    constructor(
//        context: Context,
//        attrs: AttributeSet?,
//        defStyleAttr: Int = R.attr.nizekButtonStyle
//    ) : super(context, attrs, defStyleAttr) {
//        bind(attrs, defStyleAttr)
//    }

//     constructor(
//         context: Context,
//         attrs: AttributeSet?,
//         defStyleAttr: Int,
//         defStyleRes: Int
//     ) : super(context, attrs, defStyleAttr, defStyleRes)


    init {
        LayoutInflater.from(context).inflate(R.layout.button_nizek, this)
        manager = DrawManager(this, attrs, defStyleAttr)
        manager?.drawButton()
        //bind(attrs, defStyleAttr)
    }

//    private fun bind(attrs: AttributeSet?, defStyleAttr: Int) {
//        manager = DrawManager(this, attrs, defStyleAttr)
//        manager?.drawButton()
//    }

}