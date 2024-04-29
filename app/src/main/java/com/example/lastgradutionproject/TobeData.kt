package com.example.lastgradutionproject

data class TobeData(
    val mytitle:String
)

val tabs = listOf(
    TobeData(mytitle = Tabs.HISTORY.value),
    TobeData(mytitle = Tabs.PROCESSING.value),
    TobeData(mytitle = Tabs.SHIPPED.value)
)

enum class Tabs(val value:String){
    HISTORY("History"),
    PROCESSING("Processing"),
    SHIPPED("Shipped")
}