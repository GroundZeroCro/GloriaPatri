package com.groundzero.gloriapatri.ui.decisiondialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import com.groundzero.gloriapatri.databinding.DialogDecisionBinding

class DecisionDialog : DialogFragment() {

    private val args by navArgs<DecisionDialogArgs>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println(args)
        val binding =
            DialogDecisionBinding.inflate(inflater, container, false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        return binding.root
    }
}