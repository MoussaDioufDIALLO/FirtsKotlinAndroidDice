package com.codingwithme.essaidice.firstclass

import com.codingwithme.essaidice.R

class DiceRollerImageProvider
{
    val image = diceFaces().shuffled().first()
    
    private fun diceFaces()= listOf(
        R.drawable.dice_1,
        R.drawable.dice_2,
        R.drawable.dice_3,
        R.drawable.dice_4,
        R.drawable.dice_5,
        R.drawable.dice_6
    )
}
