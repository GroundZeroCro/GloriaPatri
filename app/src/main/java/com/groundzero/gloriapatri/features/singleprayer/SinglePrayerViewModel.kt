package com.groundzero.gloriapatri.features.singleprayer

import androidx.lifecycle.ViewModel
import com.groundzero.gloriapatri.features.bookmarks.data.BookmarksRepository
import com.groundzero.gloriapatri.features.prayers.data.Prayer
import com.groundzero.gloriapatri.features.prayers.data.PrayersDao
import javax.inject.Inject

class SinglePrayerViewModel @Inject constructor(
  private val dao: PrayersDao,
  private val repository: BookmarksRepository
) : ViewModel() {

  val prayer = fun(prayerId: String): Prayer = dao.getPrayerPerPrayerId(prayerId)
  val addBookmark = fun(prayer: Prayer) = repository.addBookmark(prayer)
  val bookmarks = repository.getBookmarks()
}