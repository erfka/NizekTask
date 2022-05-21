package com.erfka.nizekbutton.drawer

import android.graphics.drawable.GradientDrawable
import android.view.View
import com.erfka.nizekbutton.NizekButton
import com.erfka.nizekbutton.util.RippleEffect
import com.erfka.nizekbutton.model.NizekButtonModel
import com.erfka.nizekbutton.pxToDp

internal class ContainerDrawer(val view: NizekButton, val button: NizekButtonModel) :
    Drawer<NizekButton, NizekButtonModel>(view, button) {

    private lateinit var container: GradientDrawable

    override fun draw() {
        initContainer()
    }

    override fun isReady(): Boolean {
        return view.visibility != View.GONE
    }

    private fun initContainer() {
        container = GradientDrawable()
        container.cornerRadius = pxToDp(button.cornerRadius)
        view.elevation = button.elevation
        setButtonColor()
        addRipple()
    }

    private fun setButtonColor() {
        container.setColor(button.backgroundColor)
        container.setStroke(button.borderWidth.toInt(), button.borderColor)
    }

    private fun addRipple() {
        view.isEnabled = true
        view.isClickable = true
        view.isFocusable = true
        RippleEffect.createRipple(
            view,
            button.rippleColor,
            button.cornerRadius,
            container
        )
    }

    override fun updateLayout() {
        draw()
    }

}