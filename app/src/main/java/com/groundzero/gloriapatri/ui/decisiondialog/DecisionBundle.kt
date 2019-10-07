package com.groundzero.gloriapatri.ui.decisiondialog

import android.content.Context
import android.os.Bundle
import com.groundzero.gloriapatri.R

val decisionBundle = fun(context: Context, decision: Decision) = Bundle().apply {
  putSerializable(
    context.resources.getString(R.string.decision_dialog_key_serialization),
    decision
  )
}