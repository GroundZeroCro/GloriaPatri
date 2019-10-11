package com.groundzero.gloriapatri.features.prayers.all.content

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.groundzero.gloriapatri.R
import com.groundzero.gloriapatri.databinding.FragmentPrayersContentBinding
import com.groundzero.gloriapatri.di.helper.Injectable
import com.groundzero.gloriapatri.ui.adapter.ContentAdapter
import com.groundzero.gloriapatri.ui.adapter.MarginItemDecoration
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_prayers_content.*
import javax.inject.Inject

/**
 * TAG represents prayer category
 * Fragment is receiving argument TAG and queueing only required tags from
 * local SQLite database
 */
class PrayersContentFragment : Fragment(), Injectable, ScrollingListener {

  @Inject
  lateinit var presenter: PrayersContentPresenter

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return FragmentPrayersContentBinding.inflate(inflater, container, false).apply {
      val adapter =
        ContentAdapter(this@PrayersContentFragment)
      prayersRecyclerView.apply {
        this.adapter = adapter
        this.addItemDecoration(
          MarginItemDecoration(resources.getDimension(R.dimen.item_prayer_recycler_margin).toInt())
        )
      }
      adapter.submitList(presenter.prayers(presenter.getTag(arguments!!)))
    }.root
  }

  override fun getRecyclerScrollState() = prayers_recycler_view.scrollState

  override fun onAttach(context: Context) {
    super.onAttach(context)
    AndroidSupportInjection.inject(this)
  }
}