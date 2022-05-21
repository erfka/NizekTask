package com.erfka.nizekbutton.model

import android.graphics.drawable.Drawable

data class NizekButtonModel(
    var text: String? = "",
    var textSize: Float = 0f,
    var textColor: Int = 0,
    var subText: String?,
    var subTextSize: Float = 0f,
    var subTextColor: Int = 0,
    var icon: Drawable? = null,
    var iconTint: Int = 0,
    var iconWidth: Float = 0f,
    var iconHeight: Float = 0f,
    var backgroundColor: Int = 0,
    var rippleColor: Int = 0,
    var cornerRadius: Float = 0f,
    var borderColor: Int = 0,
    var borderWidth: Float = 0f,
    var elevation: Float = 0f
)

