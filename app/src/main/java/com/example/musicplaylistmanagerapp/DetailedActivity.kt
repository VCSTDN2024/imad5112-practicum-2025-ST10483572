package com.example.musicplaylist

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.musicplaylistmanagerapp.R

class DetailedActivity : AppCompatActivity() {

    private lateinit var tvSongs: TextView
    private lateinit var btnAvg: Button
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        tvSongs = findViewById(R.id.tvSongs)
        btnAvg = findViewById(R.id.btnAverage)
        btnBack = findViewById(R.id.btnBack)

        val titles = intent.getStringArrayListExtra("titles") ?: arrayListOf()
        val artists = intent.getStringArrayListExtra("artists") ?: arrayListOf()
        val ratings = intent.getIntegerArrayListExtra("ratings") ?: arrayListOf()
        val comments = intent.getStringArrayListExtra("comments") ?: arrayListOf()

        val displayText = StringBuilder()
        for (i in titles.indices) {
            displayText.append("🎵 ${titles[i]} by ${artists[i]} - Rating: ${ratings[i]}/5\nComments: ${comments[i]}\n\n")
        }

        tvSongs.text = displayText.toString()

        btnAvg.setOnClickListener {
            if (ratings.isNotEmpty()) {
                val avg = ratings.sum().toDouble() / ratings.size
                Toast.makeText(this, "Average Rating: %.2f".format(avg), Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "No songs in playlist!", Toast.LENGTH_SHORT).show()
            }
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}

