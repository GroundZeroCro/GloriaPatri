package com.groundzero.gloriapatri.ui.decisiondialog

interface Decison {
    fun implement(decisionResponse: DecisionResponse, deleteItem: Boolean)
    fun dialogDecisionTitle(): String
    fun dialogDecisionMessage(): String
    fun dialogPositiveButtonText(): String
    fun dialogNegativeButtonText(): String
}