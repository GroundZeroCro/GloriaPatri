package com.groundzero.gloriapatri.ui.decisiondialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.groundzero.gloriapatri.R
import com.groundzero.gloriapatri.databinding.DialogDecisionBinding

/**
 * Dialog is responsible of making a yes or no decision
 * and it's abstract implementation makes it usable in
 * all application yes and not dialog situations.
 * Layout text data and it's type are passed over bundle.
 */
class DecisionDialog : DialogFragment() {

    interface Listener {
        fun onSelectedAnswer(decisionType: DecisionType, isConfirmed: Boolean)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        return DialogDecisionBinding
            .inflate(inflater, container, false).apply {

                arguments
                    ?: throw DecisionDialogException(getString(R.string.decision_dialog_exception_no_bundle))

                arguments?.let {
                    val decision = Decision(
                        it.getString(getString(R.string.decision_dialog_key_title))!!,
                        it.getString(getString(R.string.decision_dialog_key_text))!!,
                        it.getString(getString(R.string.decision_dialog_key_positive_button))!!,
                        it.getString(getString(R.string.decision_dialog_key_negative_button))!!,
                        DecisionType.valueOf(it.getInt(getString(R.string.decision_dialog_key_code)))!!
                    )

                    this.decision = decision

                    val listener = parentFragment as Listener

                    decisionPositive.setOnClickListener {
                        listener.onSelectedAnswer(decision.type, true)
                        dismiss()
                    }
                    decisionNegative.setOnClickListener {
                        listener.onSelectedAnswer(decision.type, false)
                        dismiss()
                    }
                }
            }.root
    }
}