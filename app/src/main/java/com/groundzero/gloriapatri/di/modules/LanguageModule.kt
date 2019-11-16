package com.groundzero.gloriapatri.di.modules

import android.app.Application
import com.groundzero.gloriapatri.R
import com.groundzero.gloriapatri.utils.LanguageUtils
import com.groundzero.gloriapatri.utils.SharedPreferencesUtils
import com.groundzero.gloriapatri.utils.SupportedLanguages
import dagger.Module
import dagger.Provides

@Module
class LanguageModule {

  @Provides
  fun provideLocale(
    context: Application,
    sharedPreferencesUtils: SharedPreferencesUtils
  ): SupportedLanguages {
    val locale: String =
      sharedPreferencesUtils.getStringValue(context.getString(R.string.locale_key)) ?:
      LanguageUtils.getLocaleString().getLocale()
    println("Locale from dagger 2: $locale")

    return SupportedLanguages.getEnum(locale)!!
  }
}