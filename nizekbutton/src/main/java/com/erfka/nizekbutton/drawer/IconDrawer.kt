package com.erfka.nizekbutton.drawer

import android.widget.ImageView
import com.erfka.nizekbutton.drawer.Drawer
import com.erfka.nizekbutton.model.NizekButtonModel

internal class IconDrawer(val iv: ImageView, val button: NizekButtonModel) :
    Drawer<ImageView, NizekButtonModel>(iv, button) {

    override fun draw() {
        initIcon()
    }

    override fun isReady(): Boolean {
        return button.icon != null
    }

    private fun initIcon(): ImageView {

        iv.setImageDrawable(button.icon)
        iv.setColorFilter(button.iconTint)

//        val iconParams = ConstraintLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
//        iconParams.width = button.iconWidth.toInt()
//        iconParams.height = button.iconHeight.toInt()
//        iv.layoutParams = iconParams

        return iv
    }



    override fun updateLayout() {
        initIcon()
    }

}
