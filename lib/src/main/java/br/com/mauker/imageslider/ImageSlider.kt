package br.com.mauker.imageslider

import android.content.Context
import android.graphics.Color
import android.support.constraint.ConstraintLayout
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

import java.util.ArrayList


class ImageSlider(mContext: Context, attrs: AttributeSet) : ConstraintLayout(mContext, attrs) {
    private lateinit var root: View
    private lateinit var pager: ViewPager

    private val sliderItems = ArrayList<SliderItem>()
    private lateinit var mSectionsPagerAdapter: SliderAdapter

    private lateinit var dotsLayout: LinearLayout
    private var dots: MutableList<TextView> = mutableListOf()
    private var activeDotPos = -1

    // Configurable dot settings
    private var selectedDotColor = Color.WHITE
    private var dotColor = Color.parseColor("#40ffffff")
    private var dotSize = 25f

    init {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet) {
        root = View.inflate(context, R.layout.slider_content, this)
        pager = root.findViewById(R.id.pager)
        dotsLayout = root.findViewById(R.id.dotsLayout)

        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                switchDots(position, activeDotPos)
                activeDotPos = position
            }

            override fun onPageSelected(position: Int) {}

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

//    fun showDots() {
//        dotsLayout?.visibility = View.VISIBLE // TODO
//    }
//
//    fun hideDots() {
//        dotsLayout?.visibility = View.GONE // TODO
//    }

    private fun switchDots(position: Int, activeDotPos: Int) {
        if (activeDotPos != -1) {
            val oldPosition = dotsLayout.getChildAt(activeDotPos) as TextView
            val newPosition = dotsLayout.getChildAt(position) as TextView
            
            oldPosition.setTextColor(dotColor)
            newPosition.setTextColor(selectedDotColor)
        }
    }

    fun setPages(sliderItems: List<SliderItem>) {
        this.sliderItems.clear()
        this.sliderItems.addAll(sliderItems)
        mSectionsPagerAdapter = SliderAdapter((context as android.support.v4.app.FragmentActivity).supportFragmentManager, sliderItems)

        if (sliderItems.isNotEmpty()) {
            pager.adapter = mSectionsPagerAdapter
            pager.offscreenPageLimit = sliderItems.size
        }

        initDots()
    }

    private fun initDots() {
        dotsLayout.removeAllViews()
        dots.clear()

        val visibility = if (sliderItems.isNotEmpty()) View.VISIBLE else View.GONE

        dotsLayout.visibility = visibility

        for (i in 0 until sliderItems.size) {
            val tv = TextView(context)
            dots.add(tv)

            dots[i].text = "\u2022"

            dots[i].textSize = dotSize

            if (i != 0) {
                dots[i].setTextColor(dotColor)

            } else {
                dots[i].setTextColor(selectedDotColor)
            }

            dotsLayout.addView(dots[i])
        }
    }
}
