package com.groundzero.gloriapatri.di.coremodules

import com.groundzero.gloriapatri.features.prayers.ui.base.PrayersFragment
import com.groundzero.gloriapatri.features.prayers.ui.content.PrayersContentFragment
import com.groundzero.gloriapatri.features.singleprayer.SinglePrayerFragment
import com.groundzero.gloriapatri.ui.decisiondialog.DecisionDialog
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
    abstract fun contributeDecisionDialog(): DecisionDialog
}