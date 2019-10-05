package com.groundzero.gloriapatri.ui.toolbar

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.groundzero.gloriapatri.R

class ToolbarButton<T>(
    private val context: Context,
    private val clazz: Class<T>,
    private val resource: Int,
    private val onClick: () -> Unit
) {

    fun getButton(): T {
        val view: View? =
            when (clazz) {
                ImageButton::class.java -> ImageButton(context).apply {
                    layoutParams = getParams(context)
                    setImageDrawable(context.getDrawable(resource))
                }
                Button::class.java -> Button(context).apply {
                    layoutParams = getParams(context)
                    text = context.getString(resource)
                    setTextColor(ContextCompat.getColor(context, R.color.colorTextPrimaryLight))
                }
                else -> {
                    throw ToolbarException(context.getString(R.string.toolbar_exception_wrong_view_passed))
                }
            }
        view?.setBackgroundColor(Color.TRANSPARENT)
        view?.setOnClickListener { onClick.invoke() }

        return view as T
    }

    private fun getParams(context: Context): LinearLayout.LayoutParams =
        LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        ).apply {
            rightMargin = context.resources.getDimension(R.dimen.semi_large_padding).toInt()
        }
}