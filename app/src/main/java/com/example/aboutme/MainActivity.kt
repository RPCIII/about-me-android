package com.example.aboutme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.String.valueOf

const val EXTRA_MESSAGE = "com.example.aboutme.MESSAGE"

var colorCounter = 0
var iceCreamCounter = 0
var movieCounter = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //gets data for activity depending on
    //which button is pressed
    fun countClick(view: View) {

        //stores response for intent
        val favorite: String

        //selects ID of counters to display
        val colorView = findViewById<TextView>(R.id.colorViewCount)
        val iceCreamView = findViewById<TextView>(R.id.iceCreamViewCount)
        val movieView = findViewById<TextView>(R.id.movieViewCount)

        //switch statement to check button ID
        when(view.id) {

            //sets activity for color
            //increments corresponding counter
            R.id.colorButton -> {

                colorCounter += 1

                colorView.text = valueOf(colorCounter)

                favorite = getString(R.string.colorResponse)

                Log.d("TAG", "Opening activity for: $colorButton")

                createToast()

                createIntent(favorite)
            }

            //sets activity for ice cream
            //increments corresponding counter
            R.id.iceCreamButton -> {

                iceCreamCounter += 1

                iceCreamView.text = valueOf(iceCreamCounter)

                favorite = getString(R.string.iceCreamResponse)

                Log.d("TAG", "Opening activity for: $iceCreamButton")

                createToast()

                createIntent(favorite)
            }

            //sets activity for movie
            //increments corresponding counter
            R.id.movieButton -> {

                movieCounter += 1

                movieView.text = valueOf(movieCounter)

                favorite = getString(R.string.movieResponse)

                Log.d("TAG", "Opening activity for: $movieButton")

                createToast()

                createIntent(favorite)
            }
        }
    }

    //creates and opens tailored intent with data from countClick
    private fun createIntent(favorite: String) {

        val intent = Intent(this, FavoritesActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, favorite)
        }

        startActivity(intent)

    }

    //create toast
    private fun createToast() {
        val toast = Toast.makeText(this, "Counter Incremented", Toast.LENGTH_LONG)
        toast.show()
    }
}
