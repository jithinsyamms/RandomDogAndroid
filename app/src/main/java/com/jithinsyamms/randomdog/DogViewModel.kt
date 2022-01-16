package com.jithinsyamms.randomdog

import android.graphics.Bitmap
import android.util.Log
import com.jithinsyamms.randomdog.manager.ImageManager
import com.jithinsyamms.randomdog.network.NetworkManager




class DogViewModel {

    var listener: ImageListener? = null

    constructor(listener: ImageListener) {
        this.listener = listener
    }

    fun fetchRandomDog() {
        NetworkManager.getRandomDog{ bitmap ->
            Log.d("Network", "JithinSyam Received bitmap")
            listener?.imageDownloaded(bitmap)
            ImageManager.cacheImage(bitmap)
        }
    }

    fun getAllImages() : List<Bitmap> {
        return ImageManager.getAllImages().reversed()
    }

    fun clearDogs() {
        ImageManager.clearAll()
    }


}