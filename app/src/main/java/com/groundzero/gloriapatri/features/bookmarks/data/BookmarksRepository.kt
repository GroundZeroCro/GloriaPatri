package com.groundzero.gloriapatri.features.bookmarks.data

import com.groundzero.gloriapatri.features.prayers.data.Prayer
import javax.inject.Inject

class BookmarksRepository @Inject constructor(private val dao: BookmarksDao) {

  fun addBookmark(prayer: Prayer) = dao.addBookmark(BookmarkPrayer(prayer))
  fun removeBookmark(prayer: Prayer) = dao.removeBookmark(BookmarkPrayer(prayer))
  fun getBookmarks() = dao.getBookmarks()
}