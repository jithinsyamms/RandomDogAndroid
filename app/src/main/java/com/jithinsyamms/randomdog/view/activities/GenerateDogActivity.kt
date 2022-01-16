package com.jithinsyamms.randomdog.view.activities

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jithinsyamms.randomdog.R
import com.jithinsyamms.randomdog.image.ImageListener
import com.jithinsyamms.randomdog.view.viewmodel.DogViewModel


class GenerateDogActivity : AppCompatActivity(), ImageListener {

    private var dogImageView: ImageView? = null
    private var dogViewModel = DogViewModel(this)
    private lateinit var generateButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generate_dog)
        dogImageView  = findViewById(R.id.dogImageView)
        generateButton = findViewById(R.id.generate)
        generateButton.setOnClickListener {
            generateButton.isEnabled = false
            dogViewModel.fetchRandomDog()
        }
    }

    override fun imageDownloaded(image: Bitmap) {
        dogImageView?.setImageBitmap(image)
        generateButton.isEnabled = true
    }

    override fun downloadError() {
        generateButton.isEnabled = true
        Toast.makeText(this,"Download Error", Toast.LENGTH_SHORT).show()
    }
}