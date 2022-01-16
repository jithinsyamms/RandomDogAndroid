package com.jithinsyamms.randomdog.view.activities

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jithinsyamms.randomdog.R
import com.jithinsyamms.randomdog.image.ImageListener
import com.jithinsyamms.randomdog.utils.Utils
import com.jithinsyamms.randomdog.view.viewmodel.DogViewModel


class GenerateDogActivity : AppCompatActivity(), ImageListener {

    private var dogImageView: ImageView? = null
    private var dogViewModel = DogViewModel(this)
    private lateinit var generateButton:Button
    private var downloadedImage: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generate_dog)
        dogImageView  = findViewById(R.id.dogImageView)
        generateButton = findViewById(R.id.generate)

        if (savedInstanceState != null) {
            val imageBytes = savedInstanceState.getByteArray("BitmapImage")
            if (imageBytes != null) {
                downloadedImage = Utils.getImage(imageBytes)
                dogImageView?.setImageBitmap(downloadedImage)
            }
        }

        generateButton.setOnClickListener {
            generateButton.isEnabled = false
            dogViewModel.fetchRandomDog()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (downloadedImage != null){
            outState.putByteArray("BitmapImage", Utils.getByteArrayFromBitmap(downloadedImage!!))
        }
    }

    override fun imageDownloaded(image: Bitmap) {
        dogImageView?.setImageBitmap(image)
        downloadedImage = image
        generateButton.isEnabled = true
    }

    override fun downloadError() {
        generateButton.isEnabled = true
        Toast.makeText(this,"Download Error", Toast.LENGTH_SHORT).show()
    }
    
    


}