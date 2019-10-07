package com.groundzero.gloriapatri.ui.decisiondialog

import android.content.Context
import android.os.Bundle
import com.groundzero.gloriapatri.R

val decisionBundle = fun(context: Context, decision: Decision) = Bundle().apply {
    context.resources.also {
        putString(it.getString(R.string.decision_dialog_key_title), decision.title)
        putString(it.getString(R.string.decision_dialog_key_text), decision.text)
        putString(it.getString(R.string.decision_dialog_key_positive_button), decision.positiveButton)
        putString(it.getString(R.string.decision_dialog_key_negative_button), decision.negativeButton)
        putInt(it.getString(R.string.decision_dialog_key_code), decision.type.code)
    }
}