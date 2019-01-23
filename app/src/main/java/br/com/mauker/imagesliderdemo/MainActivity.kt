package br.com.mauker.imagesliderdemo

import android.support.v7.app.AppCompatActivity

import android.os.Bundle
import br.com.mauker.imageslider.SliderItem

import java.util.ArrayList

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sliderItems = ArrayList<SliderItem>()
        sliderItems.add(SliderItem("Test", R.drawable.slide2))
        sliderItems.add(SliderItem("", R.drawable.slide3))
        sliderItems.add(SliderItem("", R.drawable.slide4))
        sliderItems.add(SliderItem("", R.drawable.slide6))
        slider.setPages(sliderItems)
    }
}
