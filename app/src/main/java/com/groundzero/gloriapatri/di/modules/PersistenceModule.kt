package com.groundzero.gloriapatri.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.groundzero.gloriapatri.data.PersistenceDatabase
import com.groundzero.gloriapatri.features.prayers.data.PrayersDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PersistenceModule {

  @Singleton
  @Provides
  fun providePrayersDao(db: PersistenceDatabase): PrayersDao = db.getPrayersDao()

  @Singleton
  @Provides
  fun providePersistenceDatabase(app: Application) = PersistenceDatabase.getInstance(app)

  @Singleton
  @Provides
  fun provideSharedPreferences(context: Application) =
    PreferenceManager.getDefaultSharedPreferences(context)

  @Singleton
  @Provides
  fun provideSharedPreferencesEditor(sharedPreferences: SharedPreferences) =
    sharedPreferences.edit()
}