package com.groundzero.gloriapatri.di.coremodules

import android.app.Application
import android.content.Context
import com.groundzero.gloriapatri.di.modules.LanguageModule
import com.groundzero.gloriapatri.di.modules.PersistenceModule
import com.groundzero.gloriapatri.di.modules.RemoteModule
import com.groundzero.gloriapatri.di.modules.ViewModelModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
  includes = [
    PersistenceModule::class,
    ViewModelModule::class,
    RemoteModule::class,
    LanguageModule::class]
)
class AppModule {
  @Singleton
  @Provides
  fun provideContext(application: Application): Context = application.applicationContext
}