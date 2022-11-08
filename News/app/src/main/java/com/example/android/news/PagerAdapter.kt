@file:Suppress("DEPRECATION")

package com.example.android.news

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(fm: FragmentManager, behavior: Int) : FragmentPagerAdapter(fm, behavior) {

    var tabCount = behavior


    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(position: Int): Fragment =
           when(position){
               0 -> HomeFragment()
               1 -> SportsFragment()
               2 -> HealthFragment()
               3 -> ScienceFragment()
               4 -> EntertainmentFragment()
               else -> TechnologyFragment()
           }

}