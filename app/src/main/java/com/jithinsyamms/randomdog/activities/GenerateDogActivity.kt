package com.jithinsyamms.randomdog.activities

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import com.jithinsyamms.randomdog.DBHelper
import com.jithinsyamms.randomdog.DogViewModel
import com.jithinsyamms.randomdog.ImageListener
import com.jithinsyamms.randomdog.R
import com.jithinsyamms.randomdog.manager.ImageManager
import com.jithinsyamms.randomdog.network.NetworkManager


class GenerateDogActivity : AppCompatActivity(), ImageListener {

    private var dogImageView: ImageView? = null
    private var dogViewModel = DogViewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generate_dog)

        dogImageView  = findViewById<ImageView>(R.id.dogImageView)
        findViewById<Button>(R.id.generate).setOnClickListener {
            Log.d("Network", "JithinSyam calling getRandomDog in activity")
            dogViewModel.fetchRandomDog()
        }
    }

    override fun imageDownloaded(image: Bitmap) {
        dogImageView?.setImageBitmap(image)
    }
}