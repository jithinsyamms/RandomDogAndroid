package com.jithinsyamms.randomdog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RandomDogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.generate_dogs).setOnClickListener(view -> {
            Intent intent = new Intent(RandomDogActivity.this, GenerateDogActivity.class);
            startActivity(intent);
        });
        findViewById(R.id.recent_dogs).setOnClickListener(view -> {
            Intent intent = new Intent(RandomDogActivity.this, RecentDogsActivity.class);
            startActivity(intent);
        });
    }
}