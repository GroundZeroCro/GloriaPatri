package com.groundzero.gloriapatri.di.helper

import android.content.Context
import com.groundzero.gloriapatri.R
import com.groundzero.gloriapatri.utils.LanguageUtils
import com.groundzero.gloriapatri.utils.SharedPreferencesUtils
import com.groundzero.gloriapatri.utils.SupportedLanguages
import java.util.*
import javax.inject.Inject

/**
 * Checks if user has already stored locale code in shared preferences, if not,
 * app gives him one which is supported in the app
 */
class LocaleHandler @Inject constructor(
  private val context: Context,
  private val sharedPreferencesUtils: SharedPreferencesUtils,
  private val supportedLanguages: SupportedLanguages
) {


  fun instantiateAndStoreAppLocale() {
    println("Instantiating language")
    val localeKey = context.getString(R.string.locale_key)
    sharedPreferencesUtils.getStringValue(localeKey) ?: storeLocale()
  }

  private fun storeLocale() {
    println("Default locale: "+ Locale.getDefault())
    println("Storing locale "+supportedLanguages.getLocale())
    sharedPreferencesUtils.setStringValue(
      context.getString(R.string.locale_key),
      LanguageUtils.getLocaleString(Locale.getDefault().toString()).getLocale()
    )
    println("Stored shared locale " + sharedPreferencesUtils.getStringValue(context.getString(R.string.locale_key)))
  }
}