package net.example.pager

import androidx.annotation.DrawableRes

data class TabItem(
    val id: Int,
    val name: String,
    @DrawableRes val resourceIcon: Int = 0,
    val content: String? = null
)
