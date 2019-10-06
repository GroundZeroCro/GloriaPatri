package com.groundzero.gloriapatri.ui.decisiondialog

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class DecisionDialogViewModel @Inject constructor() : ViewModel() {

    private val dialogDecisionLive = MutableLiveData<Decision>()

    fun getDialogDecision() = dialogDecisionLive

    fun setDialogDecision(decision: Decision) {
        dialogDecisionLive.value = decision
    }
}