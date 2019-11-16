package com.groundzero.gloriapatri.utils

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferencesUtils @Inject constructor(
  private val sharedPreferences: SharedPreferences,
  private val sharedPreferencesEditor: SharedPreferences.Editor
) {

  fun getStringValue(key: String) = sharedPreferences.getString(key, "")?.sharedNull()
  fun setStringValue(key: String, value: String) =
    sharedPreferencesEditor.putString(key, value).apply()
}

fun String.sharedNull(): String? {
  return if(this == "") null else this
}