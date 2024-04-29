package com.example.lastgradutionproject

import androidx.annotation.DrawableRes

data class Item(
    val title:String,
    @DrawableRes val image:Int
){
    companion object{
        val items: List<Home> = listOf(
            Home(
                titl="item3",
                imag =R.drawable.img_11
            ),
            Home(
                titl="item4",
                imag =R.drawable.img_12
            ),
            Home(
                titl="item5",
                imag =R.drawable.img_13
            ),


            )}


}


