package com.jithinsyamms.randomdog.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import com.jithinsyamms.randomdog.DBHelper
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
            Log.d("Network", "JithinSyam calling getRandomDog in activity")
            NetworkManager.getRandomDog{ bitmap ->
                Log.d("Network", "JithinSyam Received bitmap")
                dogImageView?.setImageBitmap(bitmap)
                ImageManager.addImage(bitmap)

                val dbHelper = DBHelper(this)


            }
        }
    }
}