package com.groundzero.gloriapatri.ui.toolbar

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout

class ToolbarButtonGroup(context: Context) : LinearLayout(context) {

    init {
        gravity = Gravity.RIGHT
        orientation = HORIZONTAL
    }

    fun addButtons(buttonIcons: Array<out View>) {
        buttonIcons.forEach { toolbarButton -> addView(toolbarButton) }
    }

    fun onDestroy() {
        if (childCount > 0) {
            removeAllViewsInLayout()
        }
    }
}