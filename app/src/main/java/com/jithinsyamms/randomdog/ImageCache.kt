package com.jithinsyamms.randomdog

import android.graphics.Bitmap
import android.util.Log
import android.util.LruCache

class ImageCache {
    private val imageCache = HashMap<String, Bitmap>()
    private val cacheKeys  = ArrayList<String>()

    init {

    }

    fun cacheImage(image: Bitmap) {
        val key = System.currentTimeMillis().toString()
        cacheKeys.add(key)
        imageCache.put(key, image)
        Log.d("Cache", "JithinSyam cache size is " + cacheKeys.size)
    }
    fun getImages() : ArrayList<Bitmap> {
        val list = ArrayList<Bitmap> ()
        for(var key in cacheKeys){
            if (imageCache.get(key) != null) {
                list.add(imageCache.get(key))
            }
        }
    }

}