package com.groundzero.gloriapatri.features.singleprayer


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.groundzero.gloriapatri.R
import com.groundzero.gloriapatri.base.BaseFragment
import com.groundzero.gloriapatri.databinding.FragmentSinglePrayerBinding
import com.groundzero.gloriapatri.di.helper.Injectable
import com.groundzero.gloriapatri.di.helper.injectViewModel
import com.groundzero.gloriapatri.ui.decisiondialog.Decision
import com.groundzero.gloriapatri.ui.decisiondialog.DecisionDialog
import com.groundzero.gloriapatri.ui.decisiondialog.DecisionType
import com.groundzero.gloriapatri.ui.decisiondialog.decisionBundle
import com.groundzero.gloriapatri.ui.toolbar.ToolbarButton
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class SinglePrayerFragment : BaseFragment(), Injectable, DecisionDialog.Listener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: SinglePrayerViewModel
    private val args by navArgs<SinglePrayerFragmentArgs>()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = injectViewModel(viewModelFactory)
        setProgressBarVisibility(false)
        inflateToolbar()

        val binding =
            FragmentSinglePrayerBinding.inflate(inflater, container, false)
                .apply {
                    prayer = viewModel.prayer(args.prayerId)
                }
        return binding.root
    }

    private fun inflateToolbar() {
        val buttonIcons: Array<out View> = arrayOf(
            ToolbarButton(
                requireContext(),
                Button::class.java,
                R.string.add_prayer_to_bookmark
            ) { openDecisionDialog() }.getButton()
        )
        setToolbarButtons(buttonIcons)
    }

    private fun openDecisionDialog() {

        requireContext().apply {
            val decision = Decision(
                getString(R.string.dialog_bookmark_prayer_title),
                getString(R.string.dialog_bookmark_prayer_text),
                getString(R.string.dialog_bookmark_prayer_positive_button),
                getString(R.string.dialog_bookmark_prayer_negative_button),
                DecisionType.PRAYER_ADD_BOOKMARK
            )

            childFragmentManager.beginTransaction().add(
                DecisionDialog::class.java,
                decisionBundle(this, decision),
                getString(R.string.decision_dialog_tag)
            ).commit()
        }
    }

    override fun onSelectedAnswer(decisionType: DecisionType, isConfirmed: Boolean) {
        when (decisionType) {
            DecisionType.PRAYER_ADD_BOOKMARK ->
                if (isConfirmed) {
                    println("Clicked yes")
                }
        }
    }
}