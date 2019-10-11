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

  val bookmarked = dao.getBookmarkedPrayers()
  fun getSinglePrayer(prayerId: String): Prayer = dao.getPrayerPerPrayerId(prayerId)
  fun addBookmark(prayer: Prayer) = dao.addBookmark(prayer.apply { isBookmarked = true })
}