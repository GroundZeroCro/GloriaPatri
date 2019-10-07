package com.groundzero.gloriapatri.features.prayers.ui.content

import android.os.Bundle
import com.groundzero.gloriapatri.data.prayers.Prayer
import com.groundzero.gloriapatri.data.prayers.PrayersDao
import com.groundzero.gloriapatri.features.prayers.ui.base.PrayersViewModel
import javax.inject.Inject

class PrayersContentPresenter @Inject constructor(private val dao: PrayersDao) {

  val prayers = fun(tag: String): List<Prayer> { return dao.getPrayersPerTag(tag) }

  fun getTag(arguments: Bundle): String = arguments.getString(PrayersViewModel.PRAYER_TAG)!!
}