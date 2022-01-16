package com.jithinsyamms.randomdog

import android.graphics.Bitmap
import java.io.ByteArrayOutputStream
import android.graphics.BitmapFactory




class Utils {
    companion object {

        fun getByteArrayFromBitmap(bitmap: Bitmap): ByteArray {
            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100 , stream)
            return stream.toByteArray()
        }
        fun getImage(image: ByteArray): Bitmap? {
            return BitmapFactory.decodeByteArray(image, 0, image.size)
        }
    }
}