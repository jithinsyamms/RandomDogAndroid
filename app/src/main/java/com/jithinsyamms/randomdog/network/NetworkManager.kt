package com.jithinsyamms.randomdog.network

import android.graphics.Bitmap
import android.util.Log
import android.widget.ImageView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.jithinsyamms.randomdog.GlobalApplication
import org.json.JSONException

object NetworkManager {
    val RANDOM_DOG_URL = "https://dog.ceo/api/breeds/image/random"
    private var requestQueue: RequestQueue =
            Volley.newRequestQueue(GlobalApplication.instance.applicationContext)

    fun getRandomDog(completion: (Bitmap) -> Unit) {
        Log.d("Network","JithinSyam getRandomDog started")
       val request = JsonObjectRequest(Request.Method.GET,RANDOM_DOG_URL,null,{response ->
           try {
               Log.d("Network","JithinSyam received response")
               val imageUrl = response.getString("message")
               getDogImage(imageUrl, completion)
           }
           catch (error: JSONException){

           }

       }, { error ->
           Log.d("Network",error.localizedMessage)
       })
       requestQueue.add(request)
    }

    private fun getDogImage(imageUrl: String, completion: (Bitmap) -> Unit) {
        Log.d("Network","JithinSyam getDogImage started")
        val imageRequest = ImageRequest(
                imageUrl,
                { bitmap -> // response listener
                    completion(bitmap)
                    Log.d("Network","JithinSyam getDogImage success")
                    Log.d("Network","Image download Success")
                },
                400, // max width
                400, // max height
                ImageView.ScaleType.CENTER_CROP, // image scale type
                Bitmap.Config.ARGB_8888, // decode config
                { error-> // error listener
                    Log.d("Network",error.localizedMessage)
                }
        )
        requestQueue.add(imageRequest)
    }

}