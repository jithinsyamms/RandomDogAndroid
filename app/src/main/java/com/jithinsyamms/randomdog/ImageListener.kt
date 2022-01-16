package com.jithinsyamms.randomdog

import android.graphics.Bitmap

interface ImageListener {
    fun imageDownloaded(image: Bitmap)
}