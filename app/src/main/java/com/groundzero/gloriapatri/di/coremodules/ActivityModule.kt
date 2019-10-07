package com.groundzero.gloriapatri.di.coremodules

import com.groundzero.gloriapatri.base.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
  @ContributesAndroidInjector(modules = [FragmentsModule::class])
  abstract fun contributeActivity(): MainActivity
}