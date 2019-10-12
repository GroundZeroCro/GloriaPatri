package com.groundzero.gloriapatri.ui.decisiondialog

import java.io.Serializable

data class Decision(
  var title: String = "",
  var text: String = "",
  var positiveButton: String = "",
  var negativeButton: String = "",
  var type: DecisionType? = null
) : Serializable
