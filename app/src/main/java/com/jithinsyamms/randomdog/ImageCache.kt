package com.jithinsyamms.randomdog

import android.graphics.Bitmap
import android.util.Log


class ImageCache {

    private val imageCache = HashMap<String, Bitmap>()
    private val cacheKeys  = ArrayList<String>()

    fun cacheImage(key:String, image: Bitmap) {
        cacheKeys.add(key)
        imageCache[key] = image
        Log.d("Cache", "JithinSyam cache size is " + cacheKeys.size)
    }

    fun getAllImages() : ArrayList<Bitmap> {
        val imageList = ArrayList<Bitmap> ()
        for(key in cacheKeys){
            if (imageCache[key] != null) {
                imageList.add(imageCache[key]!!)
            }
        }
        return imageList
    }

    fun clearCache() {
        cacheKeys.clear()
        imageCache.clear()
    }

    fun getCacheSize() : Int {
        return cacheKeys.size
    }

    fun removeOldestImage() : String {
       val key = cacheKeys.removeFirst()
       imageCache.remove(key)
       return key
    }

}