package tech.jv3.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var dice1Val: Int = 0
    private var dice2Val: Int = 0

    lateinit var diceImage1: ImageView
    lateinit var diceImage2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage1 = findViewById(R.id.dice_image1)
        diceImage2 = findViewById(R.id.dice_image2)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {rollDice()}

        val countUpButton: Button = findViewById(R.id.count_up_button)
        countUpButton.setOnClickListener {countUp()}
    }

    private fun rollDice() {
        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
        dice1Val = (1..6).random()
        diceImage1.setImageResource(getImageResource(dice1Val))
        dice2Val = (1..6).random()
        diceImage2.setImageResource(getImageResource(dice2Val))
    }

    private fun countUp() {
        if (dice1Val in (1..5)) {
            dice1Val++
            diceImage1.setImageResource(getImageResource(dice1Val))
        }
        if (dice2Val in (1..5)) {
            dice2Val++
            diceImage2.setImageResource(getImageResource(dice2Val))
        }
    }

    private fun getImageResource(diceRoll: Int): Int {
        return when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
    }
}