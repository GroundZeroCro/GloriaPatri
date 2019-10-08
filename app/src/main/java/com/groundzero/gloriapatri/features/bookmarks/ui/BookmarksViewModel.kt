package com.groundzero.gloriapatri.features.bookmarks.ui

import androidx.lifecycle.ViewModel
import com.groundzero.gloriapatri.features.bookmarks.data.BookmarksRepository
import javax.inject.Inject

class BookmarksViewModel @Inject constructor(repository: BookmarksRepository) : ViewModel() {
  val bookmarks = repository.getBookmarks()
}