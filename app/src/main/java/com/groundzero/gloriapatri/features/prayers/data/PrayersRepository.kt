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
}