package ahmed.imagesliderdemo

import android.support.v7.app.AppCompatActivity

import android.os.Bundle

import java.util.ArrayList

import ahmed.imageslider.EasySlider
import ahmed.imageslider.SliderItem

class MainActivity : AppCompatActivity() {

    private var easySlider: EasySlider? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        easySlider = findViewById(R.id.slider)

        val sliderItems = ArrayList<SliderItem>()
        sliderItems.add(SliderItem("", R.drawable.slide2))
        sliderItems.add(SliderItem("", R.drawable.slide3))
        sliderItems.add(SliderItem("", R.drawable.slide4))
        sliderItems.add(SliderItem("", R.drawable.slide6))
        easySlider!!.setPages(sliderItems)


    }


}
