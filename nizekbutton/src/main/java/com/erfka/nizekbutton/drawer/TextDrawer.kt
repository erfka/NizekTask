package com.erfka.nizekbutton.drawer

import android.widget.TextView
import com.erfka.nizekbutton.getDensity
import com.erfka.nizekbutton.model.NizekButtonModel

internal class TextDrawer(val tv: TextView, val button: NizekButtonModel) :
    Drawer<TextView, NizekButtonModel>(tv, button) {

    override fun draw() {
        initText()
    }

    override fun isReady(): Boolean {
        return true
    }

    private fun initText() {
        tv.text = button.text
        tv.textSize = button.textSize / getDensity()
        tv.setTextColor(button.textColor)
    }


    override fun updateLayout() {
        initText()
    }

}
