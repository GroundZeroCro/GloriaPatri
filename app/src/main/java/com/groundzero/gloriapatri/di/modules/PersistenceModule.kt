package com.groundzero.gloriapatri.di.modules

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.groundzero.gloriapatri.data.PersistenceDatabase
import com.groundzero.gloriapatri.features.prayers.data.PrayersDao
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class PersistenceModule {

  @Singleton
  @Provides
  fun providePrayersDao(db: PersistenceDatabase): PrayersDao = db.getPrayersDao()

  @Singleton
  @Provides
  fun providePersistenceDatabase(app: Application, @Named(LanguageModule.NAMED_LOCALE_CODE) locale: String) =
    PersistenceDatabase.getInstance(app, locale)

  @Singleton
  @Provides
  fun provideSharedPreferences(context: Application): SharedPreferences =
    PreferenceManager.getDefaultSharedPreferences(context)

  @Singleton
  @Provides
  fun provideSharedPreferencesEditor(sharedPreferences: SharedPreferences): SharedPreferences.Editor =
    sharedPreferences.edit()
}