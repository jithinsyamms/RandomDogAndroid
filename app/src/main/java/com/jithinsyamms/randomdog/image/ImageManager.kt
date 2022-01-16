package com.jithinsyamms.randomdog.image

import android.graphics.Bitmap
import com.jithinsyamms.randomdog.GlobalApplication
import com.jithinsyamms.randomdog.utils.Utils
import com.jithinsyamms.randomdog.db.DBManager


object ImageManager {

   private const val maxImageInCache = 20
   private val imageCache = ImageCache()
   private val dbHelper = DBManager(GlobalApplication.instance.applicationContext)


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