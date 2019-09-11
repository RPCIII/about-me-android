package com.example.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class FavoritesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        //string from button press
        val response = intent.getStringExtra(EXTRA_MESSAGE)

        //assign string to text view
        val responseText = findViewById<TextView>(R.id.responseText).apply {
            text = response
        }
    }

    //closes activity
    fun goBack(view: View) {
        finish();
    }



}
