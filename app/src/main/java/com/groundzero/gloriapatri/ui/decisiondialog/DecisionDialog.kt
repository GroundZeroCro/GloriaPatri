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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        return DialogDecisionBinding
            .inflate(inflater, container, false).apply {
                decisionDialogTitle.text =
                    arguments?.getString(resources.getString(R.string.decision_dialog_key_title))
                decisionDialogText.text =
                    arguments?.getString(resources.getString(R.string.decision_dialog_key_text))
                decisionDialogPositiveButton.text =
                    arguments?.getString(resources.getString(R.string.decision_dialog_key_positive_button))
                decisionDialogNegativeButton.text =
                    arguments?.getString(resources.getString(R.string.decision_dialog_key_negative_button))

                decisionDialogPositiveButton.setOnClickListener {
                    dismiss()
                }
                decisionDialogNegativeButton.setOnClickListener {
                    dismiss()
                }
            }.root
    }
}