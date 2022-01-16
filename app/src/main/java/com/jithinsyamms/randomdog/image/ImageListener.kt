package com.jithinsyamms.randomdog.image

import android.graphics.Bitmap

interface ImageListener {
    fun imageDownloaded(image: Bitmap)
    fun downloadError()
}