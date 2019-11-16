package com.groundzero.gloriapatri.di.modules

import android.content.Context
import com.groundzero.gloriapatri.R
import com.groundzero.gloriapatri.utils.LanguageUtils
import com.groundzero.gloriapatri.utils.SharedPreferencesUtils
import com.groundzero.gloriapatri.utils.SupportedLanguages
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class LanguageModule {

  @Singleton
  @Provides
  fun provideLocale(
    context: Context,
    sharedPreferencesUtils: SharedPreferencesUtils
  ): SupportedLanguages {
    val locale: String =
      sharedPreferencesUtils.getStringValue(context.getString(R.string.locale_key))
        ?: LanguageUtils.getLocaleString().getLocale()

    return SupportedLanguages.getEnum(locale)!!
  }

  @Singleton
  @Provides
  @Named(NAMED_LOCALE_CODE)
  fun provideLocaleString(
    context: Context,
    sharedPreferencesUtils: SharedPreferencesUtils
  ): String =
    sharedPreferencesUtils.getStringValue(context.getString(R.string.locale_key))!!

  companion object {
    const val NAMED_LOCALE_CODE = "locale_code"
  }
}