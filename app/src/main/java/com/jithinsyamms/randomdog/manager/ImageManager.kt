package com.jithinsyamms.randomdog.manager

import android.graphics.Bitmap
import android.util.Log
import com.jithinsyamms.randomdog.DBHelper
import com.jithinsyamms.randomdog.GlobalApplication
import com.jithinsyamms.randomdog.ImageCache
import com.jithinsyamms.randomdog.Utils


object ImageManager {

   private val imageCache = ImageCache()
   private val dbHelper = DBHelper(GlobalApplication.instance.applicationContext)

   init {
       setupCacheFromDB()
   }

   fun setupCacheFromDB() {
       val randomDogsFromDB = dbHelper.getAllImages()
       for (dog in randomDogsFromDB) {
           imageCache.cacheImage(dog.key, dog.image)
       }
   }

   fun addImage(image: Bitmap) {
       val key = System.currentTimeMillis().toString()
       imageCache.cacheImage(key, image)
       dbHelper.addImage(key, Utils.getByteArrayFromBitmap(image))
   }
   fun getImages(): ArrayList<Bitmap> {
       return imageCache.getImages()
   }


}