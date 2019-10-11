package com.groundzero.gloriapatri.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.groundzero.gloriapatri.di.helper.ViewModelFactory
import com.groundzero.gloriapatri.di.helper.ViewModelKey
import com.groundzero.gloriapatri.features.prayers.bookmarks.BookmarksViewModel
import com.groundzero.gloriapatri.features.prayers.all.base.PrayersViewModel
import com.groundzero.gloriapatri.features.singleprayer.SinglePrayerViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

  @Binds
  @IntoMap
  @ViewModelKey(PrayersViewModel::class)
  abstract fun bindPrayersViewModel(viewModel: PrayersViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(SinglePrayerViewModel::class)
  abstract fun bindSingleprayerViewModel(viewModel: SinglePrayerViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(BookmarksViewModel::class)
  abstract fun bindBookmarkViewModel(viewModel: BookmarksViewModel): ViewModel

  @Binds
  abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}