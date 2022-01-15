package com.jithinsyamms.randomdog.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import com.jithinsyamms.randomdog.R
import com.jithinsyamms.randomdog.manager.ImageManager
import com.jithinsyamms.randomdog.network.NetworkManager


class GenerateDogActivity : AppCompatActivity() {
    var dogImageView: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generate_dog)
        dogImageView  = findViewById<ImageView>(R.id.dogImageView)
        findViewById<Button>(R.id.generate).setOnClickListener {
            NetworkManager.getRandomDog{ bitmap ->
                Log.d("Network", "Received bitmap")
                dogImageView?.setImageBitmap(bitmap)
                ImageManager.addImage(bitmap)
            }
        }
    }
}