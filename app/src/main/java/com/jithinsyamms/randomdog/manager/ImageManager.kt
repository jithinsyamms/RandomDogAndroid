package com.jithinsyamms.randomdog.manager

import android.graphics.Bitmap
import com.jithinsyamms.randomdog.ImageCache

object ImageManager {

   private val imageCache = ImageCache()
   fun addImage(image: Bitmap) {
       imageCache.cacheImage(image = image)
   }
   fun getImages(): ArrayList<Bitmap> {
       imageCache.
   }
}