package com.groundzero.gloriapatri.ui.decisiondialog

interface DecisionResponse {
    fun implementDialogDecision(function: () -> Unit, isConfirmed: Boolean)
}