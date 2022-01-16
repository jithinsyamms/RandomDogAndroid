package com.jithinsyamms.randomdog.activities

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.jithinsyamms.randomdog.R
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.ImageLoader
import com.jithinsyamms.randomdog.DogViewModel
import com.jithinsyamms.randomdog.ImageListener
import com.jithinsyamms.randomdog.manager.ImageManager


class ImageListAdapter(private val imageList: List<Bitmap>) : RecyclerView.Adapter<ImageListAdapter.ImageHolder>() {


    class ImageHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
    }

    override fun getItemCount(): Int {
        return if (imageList != null) {
            imageList!!.size
        }
        else {
            0
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.dog_list_item, parent, false)
        return ImageHolder(view)
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        val dogImage = imageList[position]

        // sets the image to the imageview from our itemHolder class
        holder.imageView.setImageBitmap(dogImage)
    }

}



class RecentDogsActivity : AppCompatActivity(), ImageListener {


    private lateinit var imageList: RecyclerView
    private var dogViewModel = DogViewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recent_dogs)
        setUpImageList()
        findViewById<Button>(R.id.clearAll).setOnClickListener {
            dogViewModel.clearDogs()
        }
    }

    fun setUpImageList() {
        imageList = findViewById(R.id.imageList)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        imageList.setLayoutManager(layoutManager)
        imageList.adapter = ImageListAdapter(dogViewModel.getAllImages())
    }

    override fun imageDownloaded(image: Bitmap) {
       
    }


}