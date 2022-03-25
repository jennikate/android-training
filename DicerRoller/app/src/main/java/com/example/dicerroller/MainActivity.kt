package com.example.dicerroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // Do a dice roll when the app starts
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Find the ImageViews in the layout
        val diceImage1: ImageView = findViewById(R.id.d1)
        val diceImage2: ImageView = findViewById(R.id.d2)

        // Create new Dice object with 6 sides and roll it
        val d6 = Dice(6)
        val d20 = Dice(20)

        // Roll the dice
        val diceRoll1 = d6.roll()
        val diceRoll2 = d20.roll()

        // Update the ImageView with the correct drawable resource ID
        diceImage1.setImageResource(diceRoll1)
        diceImage2.setImageResource(diceRoll2)

        diceImage1.contentDescription = diceRoll1.toString()
        diceImage1.contentDescription = diceRoll2.toString()
    }
}

/**
 * Roll the dice and return the result
 */
class Dice(val numSides: Int) {
    fun roll(): Int {
        val drawableResource = when ((1..numSides).random()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        return drawableResource
    }
}