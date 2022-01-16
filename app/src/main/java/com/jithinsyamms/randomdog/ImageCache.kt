package com.jithinsyamms.randomdog

import android.graphics.Bitmap
import android.util.Log


class ImageCache {

    private val imageCache = HashMap<String, Bitmap>()
    private val cacheKeys  = ArrayList<String>()

    init {

    }

    fun cacheImage(key:String, image: Bitmap) {
        cacheKeys.add(key)
        imageCache.put(key, image)
        Log.d("Cache", "JithinSyam cache size is " + cacheKeys.size)
    }

    fun getImages() : ArrayList<Bitmap> {
        val imageList = ArrayList<Bitmap> ()
        for(key in cacheKeys){
            if (imageCache.get(key) != null) {
                imageList.add(imageCache.get(key)!!)
            }
        }
        return imageList
    }
}