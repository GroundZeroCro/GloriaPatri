package com.groundzero.gloriapatri.features.prayers.data

import com.google.firebase.firestore.CollectionReference
import com.groundzero.gloriapatri.data.resultLiveData
import javax.inject.Inject

class PrayersRepository @Inject constructor(
  private val dao: PrayersDao,
  private val collection: CollectionReference
) {

  val prayers = resultLiveData(
    dataQuery = { dao.getPrayers() },
    networkCall = { collection.get() },
    saveCallResult = { dao.insertAll(it) }
  )

  val bookmarksLive = dao.getBookmarkedPrayers()
  fun getPrayerLive(prayerId: String) = dao.getPrayerPerPrayerIdLive(prayerId)
  fun getPrayer(prayerId: String) = dao.getPrayerPerPrayerId(prayerId)
  fun changBookmarkState(prayer: Prayer, isBookmarked: Boolean) =
    dao.changeBookmarkState(prayer.apply { this.isBookmarked = isBookmarked })
}