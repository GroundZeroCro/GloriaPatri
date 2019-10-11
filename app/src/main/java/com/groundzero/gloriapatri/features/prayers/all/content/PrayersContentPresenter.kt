package com.groundzero.gloriapatri.features.prayers.all.content

import android.os.Bundle
import com.groundzero.gloriapatri.features.prayers.data.Prayer
import com.groundzero.gloriapatri.features.prayers.data.PrayersDao
import com.groundzero.gloriapatri.features.prayers.all.base.PrayersViewModel
import javax.inject.Inject

class PrayersContentPresenter @Inject constructor(private val dao: PrayersDao) {

  val prayers = fun(tag: String): List<Prayer> { return dao.getPrayersPerTag(tag) }

  fun getTag(arguments: Bundle): String = arguments.getString(PrayersViewModel.PRAYER_TAG)!!
}