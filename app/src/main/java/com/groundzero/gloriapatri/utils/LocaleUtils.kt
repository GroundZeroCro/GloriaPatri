package com.groundzero.gloriapatri.utils

class LanguageUtils {

  companion object {
    fun getLocaleString(value: String): SupportedLanguages {
      return SupportedLanguages.values().find { it.locale == value.firstTwo() }
        ?: SupportedLanguages.ENGLISH
    }
  }
}

// Phone supported languages can be different for same language. E.g. hr_ , hr_BA, hr_HR
fun String.firstTwo() = this.isNotEmpty().let { this.substring(0, 2) }

enum class SupportedLanguages(internal val locale: String, private val language: String) {
  ENGLISH("en", "English"),
  CROATIAN("hr", "Croatian");

  fun getLocale(): String = locale
  fun getLanguage(): String = language
}

