package com.jithinsyamms.randomdog.view.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
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