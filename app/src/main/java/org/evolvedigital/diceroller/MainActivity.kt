package org.evolvedigital.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import org.evolvedigital.diceroller.R.id.imageView
import org.evolvedigital.diceroller.R.id.imageView2

/**
 * This activity allow users to roll a dice and view the result on screen
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result
     */
    private fun rollDice() {
        //Creates 2 new dice objects with 6 sides and rolls it
        val dice = Dice(6)

        // Calls the roll function to assign a random number to the dice
        val diceRoll = dice.roll()

        //Updates the screen with the dice roll
        val diceImage: ImageView = findViewById(imageView)

        // Determine which resource ID is to be used
        val drawableResource = when (diceRoll) {
            1 -> (R.drawable.dice_1)
            2 -> (R.drawable.dice_2)
            3 -> (R.drawable.dice_3)
            4 -> (R.drawable.dice_4)
            5 -> (R.drawable.dice_5)
            else -> (R.drawable.dice_6)
        }
        // Update the imageView with the correct drawable resource file
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()

        // This is a second object of the Dice class
        val dice1 = Dice(6)
        val diceRoll1 = dice1.roll()
        val diceImage1 : ImageView = findViewById(imageView2)
        val drawableResource1 = when (diceRoll1) {
            1 -> (R.drawable.dice_1)
            2 -> (R.drawable.dice_2)
            3 -> (R.drawable.dice_3)
            4 -> (R.drawable.dice_4)
            5 -> (R.drawable.dice_5)
            else -> (R.drawable.dice_6)
        }
        diceImage1.setImageResource(drawableResource1)
        diceImage1.contentDescription = diceRoll1.toString()

    }
}

/**
 * This is the Dice class which holds the blueprint of all the Dice instances.
 */
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
