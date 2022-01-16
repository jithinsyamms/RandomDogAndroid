package com.jithinsyamms.randomdog.view.viewmodel

import android.graphics.Bitmap
import android.widget.Toast
import com.jithinsyamms.randomdog.image.ImageListener
import com.jithinsyamms.randomdog.image.ImageManager
import com.jithinsyamms.randomdog.network.NetworkManager


class DogViewModel(listener: ImageListener) {

    private var listener: ImageListener? = listener

    fun fetchRandomDog() {
        NetworkManager.getRandomDog{ bitmap ->
            if (bitmap != null) {
                listener?.imageDownloaded(bitmap)
                ImageManager.cacheImage(bitmap)
            } else {
               listener?.downloadError()
            }

        }
    }

    fun getAllImages() : List<Bitmap> {
        return ImageManager.getAllImages().reversed()
    }

    fun clearDogs() {
        ImageManager.clearAll()
    }


}