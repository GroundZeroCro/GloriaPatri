package com.groundzero.gloriapatri.features.singleprayer


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.groundzero.gloriapatri.base.BaseFragment
import com.groundzero.gloriapatri.databinding.FragmentSinglePrayerBinding
import com.groundzero.gloriapatri.di.helper.Injectable
import com.groundzero.gloriapatri.di.helper.injectViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class SinglePrayerFragment : BaseFragment(), Injectable {

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
        val binding =
            FragmentSinglePrayerBinding.inflate(inflater, container, false).apply {
                prayer = viewModel.prayer(args.prayerId)
            }
        return binding.root
    }
}