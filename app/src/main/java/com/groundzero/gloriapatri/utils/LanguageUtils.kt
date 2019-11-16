package com.groundzero.gloriapatri.utils

import java.util.*

class LanguageUtils {

  companion object {
    fun getLocaleString(): SupportedLanguages {

      return when (Locale.getDefault().toString()) {
        "en_US" -> SupportedLanguages.CROATIAN
        "hr_" -> SupportedLanguages.CROATIAN
        else -> SupportedLanguages.CROATIAN
      }
    }
  }
}

enum class SupportedLanguages(private val locale: String, private val language: String) {
  ENGLISH("en_US", "English"),
  CROATIAN("hr_", "Croatian");

  fun getLocale(): String = locale
  fun getLanguage(): String = language

  companion object {
    fun getEnum(value: String): SupportedLanguages? = values().find {
      println(it.locale)
      it.locale == value
    }
  }
}

