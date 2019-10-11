package com.groundzero.gloriapatri.di.coremodules

import com.groundzero.gloriapatri.features.prayers.bookmarks.BookmarksFragment
import com.groundzero.gloriapatri.features.prayers.all.base.PrayersFragment
import com.groundzero.gloriapatri.features.prayers.all.content.PrayersContentFragment
import com.groundzero.gloriapatri.features.singleprayer.SinglePrayerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsModule {
  @ContributesAndroidInjector
  abstract fun contributePrayersFragment(): PrayersFragment

  @ContributesAndroidInjector
  abstract fun contributeSinglePrayerFragment(): SinglePrayerFragment

  @ContributesAndroidInjector
  abstract fun contributePrayersFragmentContent(): PrayersContentFragment

  @ContributesAndroidInjector
  abstract fun contributeBookmarkFragment(): BookmarksFragment
}