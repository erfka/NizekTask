package com.erfka.nizekbutton

import android.util.AttributeSet
import android.view.View
import com.erfka.nizekbutton.drawer.ContainerDrawer
import com.erfka.nizekbutton.drawer.IconDrawer
import com.erfka.nizekbutton.drawer.SubtextDrawer
import com.erfka.nizekbutton.drawer.TextDrawer

internal class DrawManager constructor(view: NizekButton, attrs: AttributeSet?, defStyleAttr: Int) {

    private val controller = AttributeController(view, attrs, defStyleAttr)

    private val container = ContainerDrawer(view, controller.button)
    private val icon = IconDrawer(view.findViewById(R.id.ivIcon), controller.button)
    private val text = TextDrawer(view.findViewById(R.id.tvText), controller.button)
    private val subText = SubtextDrawer(view.findViewById(R.id.tvSubText), controller.button)

    fun drawButton() {
        container.draw()
        if (icon.isReady()) icon.draw() else icon.iv.visibility = View.GONE
        text.draw()
        if (subText.isReady()) subText.draw() else subText.tv.visibility = View.GONE
    }

}
