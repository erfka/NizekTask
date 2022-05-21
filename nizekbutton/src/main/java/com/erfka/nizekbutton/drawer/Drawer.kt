package com.erfka.nizekbutton.drawer

internal abstract class Drawer<V, T> constructor(private val view: V, private val button: T) {

    abstract fun draw()

    abstract fun isReady() : Boolean

    abstract fun updateLayout()

}