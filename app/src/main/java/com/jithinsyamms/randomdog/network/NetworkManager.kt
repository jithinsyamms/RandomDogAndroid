package com.jithinsyamms.randomdog.network

import android.graphics.Bitmap
import android.widget.ImageView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.jithinsyamms.randomdog.GlobalApplication
import org.json.JSONException

object NetworkManager {
    private const val RANDOM_DOG_URL = "https://dog.ceo/api/breeds/image/random"
    private var requestQueue: RequestQueue =
            Volley.newRequestQueue(GlobalApplication.instance.applicationContext)

    fun getRandomDog(completion: (Bitmap?) -> Unit) {
       val request = JsonObjectRequest(Request.Method.GET, RANDOM_DOG_URL,null,{ response ->
           try {
               val imageUrl = response.getString("message")
               getDogImage(imageUrl, completion)
           }
           catch (error: JSONException){
             completion(null)
           }

       }, {
           completion(null)
       })
       requestQueue.add(request)
    }

    private fun getDogImage(imageUrl: String, completion: (Bitmap?) -> Unit) {
        val imageRequest = ImageRequest(
                imageUrl,
                { bitmap -> // response listener
                    completion(bitmap)

                },
                0, // max width
                0, // max height
                ImageView.ScaleType.CENTER_CROP, // image scale type
                Bitmap.Config.ARGB_8888, // decode config
                {
                    completion(null)
                }
        )
        requestQueue.add(imageRequest)
    }

}