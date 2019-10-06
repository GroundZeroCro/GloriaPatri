package com.groundzero.gloriapatri.ui.decisiondialog

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.groundzero.gloriapatri.databinding.DialogDecisionBinding
import com.groundzero.gloriapatri.di.helper.Injectable
import com.groundzero.gloriapatri.di.helper.activityInjectViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * Dialog is responsible of making a yes or no decision
 * and it's abstract implementation makes it usable in
 * all application yes and not dialog situations.
 * Layout text data and it's type are passed over bundle.
 * Text data is used for layout input, type is used
 * to determine what kind of context is dialog about.
 * Upon closing, dialog is emitting value over ViewModel.
 * ViewModel has to be observed in targetFragment.
 */
class DecisionDialog : DialogFragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: DecisionDialogViewModel
    private val args by navArgs<DecisionDialogArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        viewModel = requireActivity().activityInjectViewModel(viewModelFactory)

        return DialogDecisionBinding
            .inflate(inflater, container, false).apply {
                decisionDialogTitle.text = args.title
                decisionDialogText.text = args.text
                decisionDialogPositiveButton.text = args.positiveButton
                decisionDialogNegativeButton.text = args.negativeButton

                decisionDialogPositiveButton.setOnClickListener {
                    viewModel.setDialogDecision(requireDecision(true))
                    dismiss()
                }
                decisionDialogNegativeButton.setOnClickListener {
                    viewModel.setDialogDecision(requireDecision(false))
                    dismiss()
                }
            }.root
    }

    private fun requireDecision(isAccepted: Boolean) =
        Decision(DecisionType.valueOf(args.decisionType)!!, isAccepted)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }
}