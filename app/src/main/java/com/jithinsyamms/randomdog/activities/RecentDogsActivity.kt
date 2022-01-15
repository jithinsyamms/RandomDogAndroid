package com.jithinsyamms.randomdog.activities

import android.content.Context
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.jithinsyamms.randomdog.R
import androidx.recyclerview.widget.LinearLayoutManager


class ImageListAdapter: RecyclerView.Adapter<ImageListAdapter.ImageHolder> {

    class ImageHolder: RecyclerView.ViewHolder {

    }
    class ImageHolder(view: ImageView) : RecyclerView.ViewHolder(ImageView) {
        val imageView: ImageView = view.findViewById(R.id.imageview)
    }

    var context: Context? = null
    var imageList: ArrayList<Bitmap> = ArrayList()

    constructor(context: Context, imageList:ArrayList<Bitmap>){
      this.context = context
      this.imageList.addAll(imageList)
    }

    override fun getItemCount(): Int {
        if (imageList != null) {
            return imageList!!.size
        }
        else {
            return 0
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {

    }

}



class RecentDogsActivity : AppCompatActivity() {


    private lateinit var imageList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recent_dogs)
        imageList = findViewById(R.id.imageList)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        imageList.setLayoutManager(layoutManager)

    }
}