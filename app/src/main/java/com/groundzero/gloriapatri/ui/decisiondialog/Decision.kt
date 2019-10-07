package com.groundzero.gloriapatri.ui.decisiondialog

import java.io.Serializable

data class Decision(
  val title: String,
  val text: String,
  val positiveButton: String,
  val negativeButton: String,
  val type: DecisionType
) : Serializable
