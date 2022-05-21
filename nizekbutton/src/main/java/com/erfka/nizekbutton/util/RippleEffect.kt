package com.erfka.nizekbutton.util

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import android.view.View
import com.erfka.nizekbutton.pxToDp

class RippleEffect {

    companion object {
        fun createRipple(
            view: View,
            rippleColor: Int,
            corner: Float,
            container: GradientDrawable
        ) {

            val mask = GradientDrawable()
            mask.cornerRadius = pxToDp(corner)
            mask.setColor(Color.GRAY)

            val colors = ColorStateList(
                arrayOf(intArrayOf(android.R.attr.state_enabled)),
                intArrayOf(rippleColor)
            )
            val rd = RippleDrawable(colors, container, mask)
            view.background = rd

        }
    }

}