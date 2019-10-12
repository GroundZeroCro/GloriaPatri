package com.groundzero.gloriapatri.features.singleprayer

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.groundzero.gloriapatri.features.prayers.data.Prayer
import com.groundzero.gloriapatri.features.prayers.data.PrayersRepository
import javax.inject.Inject

/**
 * @Prayer
 * Asynchronous for UI button state change
 * Synchronous for DecisionDialog callback, liveData.value is null
 */
class SinglePrayerViewModel @Inject constructor(
  private val repository: PrayersRepository
) : ViewModel() {

  val prayerLive =
    fun(prayerId: String): LiveData<Prayer> = repository.getPrayerLive(prayerId)

  val prayer =
    fun(prayerId: String): Prayer = repository.getPrayer(prayerId)

  val changeBookmarkedState =
    fun(prayer: Prayer, isBookmarked: Boolean) = repository.changBookmarkState(prayer, isBookmarked)
}