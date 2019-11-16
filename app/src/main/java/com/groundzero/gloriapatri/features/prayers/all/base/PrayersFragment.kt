package com.groundzero.gloriapatri.features.prayers.all.base


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.groundzero.gloriapatri.R
import com.groundzero.gloriapatri.base.BaseFragment
import com.groundzero.gloriapatri.data.Result
import com.groundzero.gloriapatri.databinding.FragmentPrayersBinding
import com.groundzero.gloriapatri.di.helper.Injectable
import com.groundzero.gloriapatri.di.helper.injectViewModel
import com.groundzero.gloriapatri.ui.toolbar.ToolbarButton
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class PrayersFragment : BaseFragment(), Injectable {

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory
  private lateinit var viewModel: PrayersViewModel
  private lateinit var viewPagerAdapter: PrayersViewPagerAdapter

  override fun onAttach(context: Context) {
    super.onAttach(context)
    AndroidSupportInjection.inject(this)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewPagerAdapter = PrayersViewPagerAdapter(childFragmentManager)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View? {
    inflateToolbar()
    val binding =
      FragmentPrayersBinding.inflate(LayoutInflater.from(context), container, false).apply {
        prayersTabs.setupWithViewPager(prayersViewPager)
      }
    viewModel = injectViewModel(viewModelFactory)

    viewModel.prayers.observe(this, Observer {
      when (it.status) {
        Result.Status.LOADING -> setProgressBarVisibility(true)
        Result.Status.SUCCESS -> {
          setProgressBarVisibility(false)
          viewPagerAdapter.generateChildFragments(it.data!!)
          binding.prayersViewPager.adapter = viewPagerAdapter
        }
        Result.Status.ERROR -> {
          setProgressBarVisibility(false)
          showMessage(resources.getString(R.string.error_fetching_data))
        }
      }
    })

    return binding.root
  }

  private fun inflateToolbar() {
    val buttonIcons: Array<out View> = arrayOf(
      ToolbarButton(
        requireContext(),
        ImageButton::class.java,
        R.drawable.bookmark_svg
      ) {findNavController().navigate(R.id.bookmarksFragment)}.getButton()
    )
    setToolbarButtons(buttonIcons)
  }
}