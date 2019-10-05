package com.groundzero.gloriapatri.features.prayers.ui.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.groundzero.gloriapatri.data.prayers.Prayer
import com.groundzero.gloriapatri.features.prayers.ui.content.PrayersContentFragment

class PrayersViewPagerAdapter(fm: FragmentManager) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList[position]
    }

    fun generateChildFragments(prayers: List<Prayer>) {
        if (isEmpty()) {
            prayers.forEach { prayer ->
                if (!containsTitle(prayer.tag)) {
                    this.addFragment(
                        completeFragment(PrayersContentFragment(), prayer.tag), prayer.tag
                    )
                }
            }
        }
    }

    private fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

    private fun isEmpty() = count == 0

    private fun containsTitle(tag: String) = mFragmentTitleList.contains(tag)

    private fun <T : Fragment> completeFragment(fragment: T, bundleValue: String): T =
        fragment.apply {
            arguments = getBundle(bundleValue)
        }

    private fun getBundle(value: String) = Bundle().apply {
        this.putString(PrayersViewModel.PRAYER_TAG, value)
    }
}