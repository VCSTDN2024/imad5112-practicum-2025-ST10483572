package com.example.musicplaylistmanagerapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {  //

    // List to store songs
    private val playlist = mutableListOf<String>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // View references
        val songInput = findViewById<EditText>(R.id.editTextSongName)
        val addButton = findViewById<Button>(R.id.btnAdd)
        val playlistDisplay = findViewById<TextView>(R.id.txtPlaylist)

        // Add button logic
        addButton.setOnClickListener {
            val songName = songInput.text.toString().trim()
            if (songName.isNotEmpty()) {
                playlist.add(songName)
                songInput.text.clear()
                updatePlaylistDisplay(playlistDisplay)
            } else {
                songInput.error = "Please enter a song name"
            }
        }
    }

    private fun updatePlaylistDisplay(playlistDisplay: TextView) {
        playlistDisplay.text = playlist.joinToString(separator = "\n")
    }
}
