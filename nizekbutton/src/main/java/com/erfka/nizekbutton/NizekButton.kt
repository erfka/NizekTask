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
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat

class NizekButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.nizekButtonStyle
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val tvText: TextView
    private val tvSubText: TextView
    private val ivIcon: ImageView

    var text: String = ""
        set(value) {
            field = value
            tvText.text = value
        }

    var subText: String? = null
        set(value) {
            field = value
            tvSubText.text = value
            tvSubText.visibility = if (value.isNullOrEmpty()) View.GONE else View.VISIBLE
        }

    var icon: Drawable? = null
        set(value) {
            field = value
            if (value == null) {
                ivIcon.visibility = View.GONE
            } else {
                ivIcon.visibility = View.VISIBLE
                ivIcon.setImageDrawable(icon)
            }
        }


    init {

        LayoutInflater.from(context).inflate(R.layout.button_nizek, this)

        tvText = findViewById(R.id.tvText)
        tvSubText = findViewById(R.id.tvSubText)
        ivIcon = findViewById(R.id.ivIcon)

        val typedArray =
            context.obtainStyledAttributes(attrs, R.styleable.NizekButton, defStyleAttr, 0)
        typedArray.getString(R.styleable.NizekButton_nizek_text).let { text = it ?: "" }
        typedArray.getString(R.styleable.NizekButton_nizek_subText).let { subText = it }
        typedArray.getDrawable(R.styleable.NizekButton_nizek_icon).let { icon = it }

        typedArray.getDrawable(R.styleable.NizekButton_nizek_icon).let { icon = it }

        val imageTintColor = typedArray.getColor(R.styleable.NizekButton_nizek_tint,0)
        ImageViewCompat.setImageTintList(ivIcon, ColorStateList.valueOf(imageTintColor))

        val bgColor = typedArray.getColor(R.styleable.NizekButton_nizek_backgroundColor,0)

        val cornerRadius = typedArray.getDimension(R.styleable.NizekButton_nizek_cornerRadius, 0f)

        val sd = StateListDrawable()
        val statePressed = intArrayOf(android.R.attr.state_pressed)
        val stateNormal = intArrayOf(android.R.attr.state_enabled)

        val pressed = GradientDrawable()
        pressed.setColor(Color.RED)
        pressed.cornerRadius = cornerRadius
        pressed.shape = GradientDrawable.RECTANGLE


        val gd = GradientDrawable()
        gd.setColor(bgColor)
        gd.cornerRadius = cornerRadius

        sd.addState(statePressed, pressed)
        sd.addState(stateNormal, gd)
        this.background = sd


        typedArray.recycle()
    }

}