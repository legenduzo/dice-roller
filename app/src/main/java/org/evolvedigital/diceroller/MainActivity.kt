package org.evolvedigital.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allow users to roll a dice and view the result on screen
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * This is an instance of the first dice
      */
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()

        /**
         * This is an instance of the second dice
         */
        val secondDice = Dice(20)

        val secondDiceRoll = secondDice.roll()
        val secondResultTextView: TextView = findViewById(R.id.textView2)
        secondResultTextView.text = secondDiceRoll.toString()

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