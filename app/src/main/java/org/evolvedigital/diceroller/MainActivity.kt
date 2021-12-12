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
        rollButton.setOnClickListener {
            rollDice()
//            rollDice1()
//            rollDice2()
        }
    }

//    /**
//     * Roll the dice and update the screen with the result
//     */
//    private fun rollDice1() {
//        //Creates 2 new dice objects with 6 sides and rolls it
//        val dice1 = Dice(6)
//
//        // Calls the roll function to assign a random number to the dice
//        val diceRoll = dice1.roll()
//
//        //Updates the screen with the dice roll
//        val diceImage: ImageView = findViewById(imageView)
//
//        // Determine which resource ID is to be used
//        val drawableResource = when (diceRoll) {
//            1 -> (R.drawable.dice_1)
//            2 -> (R.drawable.dice_2)
//            3 -> (R.drawable.dice_3)
//            4 -> (R.drawable.dice_4)
//            5 -> (R.drawable.dice_5)
//            else -> (R.drawable.dice_6)
//        }
//        // Update the imageView with the correct drawable resource file
//        diceImage.setImageResource(drawableResource)
//
//        // Update the content description
//        diceImage.contentDescription = diceRoll.toString()
//
//    }
//
//    private fun rollDice2() {
//        // This is a second object of the Dice class
//        val dice2 = Dice(6)
//        val diceRoll = dice2.roll()
//        val diceImage : ImageView = findViewById(imageView2)
//        val drawableResource1 = when (diceRoll) {
//            1 -> (R.drawable.dice_1)
//            2 -> (R.drawable.dice_2)
//            3 -> (R.drawable.dice_3)
//            4 -> (R.drawable.dice_4)
//            5 -> (R.drawable.dice_5)
//            else -> (R.drawable.dice_6)
//        }
//        diceImage.setImageResource(drawableResource1)
//        diceImage.contentDescription = diceRoll.toString()
//    }

    /**
     * This function rolls both dice and update the screen with the result
     */
    private fun rollDice() {

        // Two instances of the Dice class created
        val dice1 = Dice(6)
        val dice2 = Dice(6)

        // Created a list of dice useful if we are to scale the number of dices on screen
        val dices = listOf(dice1, dice2)

        // Matches the dice objects to their screen value
        val dice1View: ImageView = findViewById(imageView)
        val dice2View: ImageView = findViewById(imageView2)

        // Rolls all the available dice in the dices list
        val diceRoll = mutableListOf<Int>()
            for (dice in dices) {
            val result = dice.roll()
                diceRoll.add(result)
        }
        // Determines the right image for the dice roll result
        val dice1Image = when (diceRoll[0]) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Sets the image to the screen
        dice1View.setImageResource(dice1Image)
        // Updates the content description
        dice1View.contentDescription = diceRoll[0].toString()

        // Repeats for the second Dice
        val dice2Image = when (diceRoll[1]) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        dice2View.setImageResource(dice2Image)
        dice2View.contentDescription = diceRoll[1].toString()
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
