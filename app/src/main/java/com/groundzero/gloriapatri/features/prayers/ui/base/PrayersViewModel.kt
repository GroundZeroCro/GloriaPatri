package com.groundzero.gloriapatri.features.prayers.ui.base

import androidx.lifecycle.ViewModel
import com.groundzero.gloriapatri.features.prayers.data.PrayersRepository
import javax.inject.Inject

class PrayersViewModel @Inject constructor(repository: PrayersRepository) :
  ViewModel() {

  val prayers = repository.prayers

  companion object {
    const val PRAYER_TAG = "tag"
  }
}