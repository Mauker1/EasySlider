package br.com.mauker.imageslider

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter


class SliderAdapter(fm: FragmentManager, private val sliderItems: List<SliderItem>) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return SliderFragment.newInstance(sliderItems[position], position)
        // TODO - Add listener
    }

    override fun getCount() = sliderItems.size
}

