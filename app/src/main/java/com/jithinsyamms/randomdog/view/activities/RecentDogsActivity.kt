package com.jithinsyamms.randomdog.view.activities

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jithinsyamms.randomdog.R
import com.jithinsyamms.randomdog.image.ImageListener
import com.jithinsyamms.randomdog.view.adapter.ImageListAdapter
import com.jithinsyamms.randomdog.view.viewmodel.DogViewModel


class RecentDogsActivity : AppCompatActivity(), ImageListener {


    private lateinit var imageList: RecyclerView
    private var dogViewModel = DogViewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recent_dogs)

        setUpImageList()
        findViewById<Button>(R.id.clearAll).setOnClickListener {
            dogViewModel.clearDogs()
            imageList.adapter = ImageListAdapter(dogViewModel.getAllImages())
        }
    }

    private fun setUpImageList() {
        imageList = findViewById(R.id.imageList)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        imageList.layoutManager = layoutManager
        imageList.adapter = ImageListAdapter(dogViewModel.getAllImages())
    }

    override fun imageDownloaded(image: Bitmap) {

    }

    override fun downloadError() {

    }


}