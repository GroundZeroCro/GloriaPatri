package com.groundzero.gloriapatri.features.singleprayer

import androidx.lifecycle.ViewModel
import com.groundzero.gloriapatri.data.prayers.Prayer
import com.groundzero.gloriapatri.data.prayers.PrayersDao
import javax.inject.Inject

class SinglePrayerViewModel @Inject constructor(private val dao: PrayersDao) : ViewModel() {

    val prayer = fun(prayerId: String): Prayer = dao.getPrayerPerPrayerId(prayerId)
}