package br.com.mauker.imageslider

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SliderItem constructor(
    var title: String,
    var url: String? = null,
    var resID: Int = 0
) : Parcelable {

    constructor(title: String, resID: Int): this(title, null, resID)

    constructor(title: String, url: String): this(title, url, 0)
}