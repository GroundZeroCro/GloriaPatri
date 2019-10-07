package com.groundzero.gloriapatri.di.modules

import android.app.Application
import com.groundzero.gloriapatri.data.PersistenceDatabase
import com.groundzero.gloriapatri.data.prayers.PrayersDao
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
}