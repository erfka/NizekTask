package com.erfka.nizekbutton

import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import com.erfka.nizekbutton.model.NizekButtonModel

internal class AttributeController(
    private val view: View,
    private val attrs: AttributeSet?,
    private val defStyleAttr: Int
) {

    lateinit var button: NizekButtonModel

    init {
        initAttr()
    }

    private fun initAttr() {

        val typedArray =
            view.context.obtainStyledAttributes(attrs, R.styleable.NizekButton, defStyleAttr, 0)

        val text = typedArray.getString(R.styleable.NizekButton_nizek_text)
        val textSize =
            typedArray.getDimension(R.styleable.NizekButton_nizek_textSize, txtPxToSp(16f))
        val textColor = typedArray.getColor(R.styleable.NizekButton_nizek_textColor, Color.DKGRAY)

        val subText = typedArray.getString(R.styleable.NizekButton_nizek_subText)
        val subTextSize =
            typedArray.getDimension(R.styleable.NizekButton_nizek_subTextSize, txtPxToSp(16f))
        val subTextColor =
            typedArray.getColor(R.styleable.NizekButton_nizek_subTextColor, Color.DKGRAY)

        val icon = typedArray.getDrawable(R.styleable.NizekButton_nizek_icon)
        val iconTint =
            typedArray.getColor(R.styleable.NizekButton_nizek_iconTint, Color.TRANSPARENT)
//        val iconWidth = typedArray.getDimension(
//            R.styleable.NizekButton_nizek_iconWidth, icon?.intrinsicWidth?.toFloat() ?: 0f
//        )
//        val iconHeight = typedArray.getDimension(
//            R.styleable.NizekButton_nizek_iconHeight, icon?.intrinsicHeight?.toFloat() ?: 0f
//        )

        val backgroundColor = typedArray.getColor(R.styleable.NizekButton_nizek_backgroundColor, 0)
        val cornerRadius = typedArray.getDimension(R.styleable.NizekButton_nizek_cornerRadius, 0f)
        val rippleColor = typedArray.getColor(
            R.styleable.NizekButton_nizek_rippleColor,
            Color.parseColor("#50FFFFFF")
        )

        val borderColor =
            typedArray.getColor(R.styleable.NizekButton_nizek_borderColor, Color.TRANSPARENT)
        val borderWidth = typedArray.getDimension(R.styleable.NizekButton_nizek_borderWidth, 0f)
        val elevation = typedArray.getDimension(R.styleable.NizekButton_nizek_elevation, dpToPx(2f))

        button = NizekButtonModel(
            text = text,
            textSize = textSize,
            textColor = textColor,
            subText = subText,
            subTextSize = subTextSize,
            subTextColor = subTextColor,
            icon = icon,
            iconTint = iconTint,
            iconWidth = 0f,
            iconHeight = 0f,
            backgroundColor = backgroundColor,
            rippleColor = rippleColor,
            cornerRadius = cornerRadius,
            borderColor = borderColor,
            borderWidth = borderWidth,
            elevation = elevation
        )

        typedArray.recycle()
    }

}
