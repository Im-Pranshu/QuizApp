package com.devcomm.quizapp

import android.graphics.Color
import java.util.*

open class BackgroundColor {
    private val mColors = arrayOf(
        "#39add1",  // light blue
        "#3079ab",  // dark blue
        "#c25975",  // mauve
        "#e15258",  // red
        "#f9845b",  // orange
        "#838cc7",  // lavender
        "#7d669e",  // purple
        "#53bbb4",  // aqua
        "#51b46d",  // green
        "#e0ab18",  // mustard
        "#637a91",  // dark gray
        "#f092b0",  // pink
        "#b7c0c7" // light gray}
    )

    //Function To generate random number
    open fun getColor(): Int {
        //Randomly generate a color
        val color: String
        val randomGenerator = Random()
        val randomNumber = randomGenerator.nextInt(mColors.size)
        color = mColors[randomNumber]
        val colorAsInt: Int = Color.parseColor(color)
        return colorAsInt
    }
}
