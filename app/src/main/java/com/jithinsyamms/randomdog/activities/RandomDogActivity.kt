package com.jithinsyamms.randomdog.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.jithinsyamms.randomdog.R

class RandomDogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.generate_dogs).setOnClickListener {
          val intent = Intent(this, GenerateDogActivity::class.java)
          startActivity(intent)
        }
        findViewById<Button>(R.id.recent_dogs).setOnClickListener {
            val intent = Intent(this, RecentDogsActivity::class.java)
            startActivity(intent)
        }

    }
}