package com.groundzero.gloriapatri.base

import android.app.Application
import com.groundzero.gloriapatri.di.helper.AppInjector
import com.groundzero.gloriapatri.di.helper.LocaleHandler
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

  @Inject
  lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>
  @Inject
  lateinit var localeHandler: LocaleHandler

  override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

  override fun onCreate() {
    super.onCreate()
    AppInjector.init(this)
    localeHandler.instantiateAndStoreAppLocale()
  }
}