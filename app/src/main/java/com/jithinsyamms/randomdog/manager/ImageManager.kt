package com.jithinsyamms.randomdog.manager

import android.graphics.Bitmap
import com.jithinsyamms.randomdog.DBHelper
import com.jithinsyamms.randomdog.GlobalApplication
import com.jithinsyamms.randomdog.ImageCache
import com.jithinsyamms.randomdog.Utils


object ImageManager {

   private const val maxImageInCache = 20
   private val imageCache = ImageCache()
   private val dbHelper = DBHelper(GlobalApplication.instance.applicationContext)


   init {
       setupCacheFromDB()
   }

   private fun setupCacheFromDB() {
       val randomDogsFromDB = dbHelper.getAllImages()
       for (dog in randomDogsFromDB) {
           imageCache.cacheImage(dog.key, dog.image)
       }
   }

   fun cacheImage(image: Bitmap) {
       removeOldestIfCacheFull()
       val key = System.currentTimeMillis().toString()
       imageCache.cacheImage(key, image)
       dbHelper.addImage(key, Utils.getByteArrayFromBitmap(image))
   }

   fun clearAll() {
      imageCache.clearCache()
      dbHelper.deleteAll()
   }

   fun getAllImages(): ArrayList<Bitmap> {
       return imageCache.getAllImages()
   }

   private fun removeOldestIfCacheFull() {
       if (imageCache.getCacheSize() >= maxImageInCache) {
            val key = imageCache.removeOldestImage()
            dbHelper.delete(key)
       }
   }
}