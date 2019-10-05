package com.groundzero.gloriapatri.features.alarm


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.groundzero.gloriapatri.R
import com.groundzero.gloriapatri.base.BaseFragment

class AlarmListFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_alarm_list, container, false)
    }
}
