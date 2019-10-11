package com.groundzero.gloriapatri.features.singleprayer

import androidx.lifecycle.ViewModel
import com.groundzero.gloriapatri.features.prayers.data.Prayer
import com.groundzero.gloriapatri.features.prayers.data.PrayersRepository
import javax.inject.Inject

class SinglePrayerViewModel @Inject constructor(
  private val repository: PrayersRepository
) : ViewModel() {

  val prayer = fun(prayerId: String): Prayer = repository.getSinglePrayer(prayerId)
  val addBookmark = fun(prayer: Prayer) = repository.addBookmark(prayer)

}