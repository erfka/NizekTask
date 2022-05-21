package com.erfka.nizekbutton.drawer

import android.text.TextUtils
import android.widget.TextView
import com.erfka.nizekbutton.getDensity
import com.erfka.nizekbutton.model.NizekButtonModel

internal class SubtextDrawer(val tv: TextView, val button: NizekButtonModel) :
    Drawer<TextView, NizekButtonModel>(tv, button) {

    override fun draw() {
        initSubtext()
    }

    override fun isReady(): Boolean {
        return button.subText != null && !TextUtils.isEmpty(button.subText)
    }

    private fun initSubtext() {
        tv.text = button.subText
        tv.textSize = button.subTextSize / getDensity()
        tv.setTextColor(button.subTextColor)
    }

    override fun updateLayout() {
        initSubtext()
    }

}
