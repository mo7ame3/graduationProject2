package com.example.lastgradutionproject

import androidx.annotation.DrawableRes

data class womenshop(
    val Title:String,
    @DrawableRes val Image:Int

) {
    companion object{
        val womenitems:List<womenshop> = listOf(
            womenshop(
                Title="item1",
                Image =R.drawable.img_1
            ),
            womenshop(
                Title="item1",
                Image =R.drawable.img_2
            ),
            womenshop(
                Title="item1",
                Image =R.drawable.img_3
            ),
            womenshop(
                Title="item1",
                Image =R.drawable.img_4
            ),
            womenshop(
                Title="item1",
                Image =R.drawable.img_5
            ),
            womenshop(
                Title="item1",
                Image =R.drawable.img_6
            ),
            womenshop(
                Title="item1",
                Image =R.drawable.img_7
            ),
            womenshop(
                Title="item1",
                Image =R.drawable.img_8
            ),
            womenshop(
                Title="item1",
                Image =R.drawable.img_9
            ),
            womenshop(
                Title="item1",
                Image =R.drawable.img_10
            ),



            )}


}
