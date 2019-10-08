package com.groundzero.gloriapatri.features.bookmarks.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.groundzero.gloriapatri.R
import com.groundzero.gloriapatri.base.BaseFragment
import com.groundzero.gloriapatri.databinding.FragmentBookmarksBinding
import com.groundzero.gloriapatri.di.helper.injectViewModel
import com.groundzero.gloriapatri.features.prayers.ui.content.ScrollingListener
import com.groundzero.gloriapatri.ui.adapter.ContentAdapter
import com.groundzero.gloriapatri.ui.adapter.MarginItemDecoration
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_bookmarks.*
import javax.inject.Inject

class BookmarksFragment : BaseFragment(), ScrollingListener {

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory
  private lateinit var viewModel: BookmarksViewModel

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    viewModel = injectViewModel(viewModelFactory)
    return FragmentBookmarksBinding.inflate(inflater, container, false).apply {
      val adapter =
        ContentAdapter(this@BookmarksFragment)
      bookmarksRecyclerView.apply {
        this.adapter = adapter
        this.addItemDecoration(
          MarginItemDecoration(resources.getDimension(R.dimen.item_prayer_recycler_margin).toInt())
        )
      }

      viewModel.bookmarks.observe(this@BookmarksFragment, Observer { t ->
        adapter.submitList(t.map { bookmarkPrayer -> bookmarkPrayer.prayer })
      })
    }.root
  }

  override fun onAttach(context: Context) {
    super.onAttach(context)
    AndroidSupportInjection.inject(this)
  }

  override fun getRecyclerScrollState(): Int = bookmarks_recycler_view.scrollState
}