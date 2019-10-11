package com.groundzero.gloriapatri.features.prayers.bookmarks

import androidx.lifecycle.ViewModel
import com.groundzero.gloriapatri.features.prayers.data.PrayersRepository
import javax.inject.Inject

class BookmarksViewModel @Inject constructor(prayersRepository: PrayersRepository) : ViewModel() {
   val bookmarks = prayersRepository.bookmarked
}