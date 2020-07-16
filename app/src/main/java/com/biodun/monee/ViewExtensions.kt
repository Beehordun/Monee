package com.biodun.monee

import android.view.View
import android.view.View.VISIBLE
import android.view.View.INVISIBLE
import android.view.View.GONE
import android.widget.Button
import androidx.annotation.DrawableRes

fun Button.deactivate(@DrawableRes id: Int) {
    this.isEnabled = false
    this.background = context.getDrawable(id)
}

fun Button.activate(@DrawableRes id: Int) {
    this.isEnabled = true
    this.background = context.getDrawable(id)
}

fun View.visible() {
    this.visibility = VISIBLE
}

fun View.inVisible() {
    this.visibility = INVISIBLE
}

fun View.gone() {
    this.visibility = GONE
}
