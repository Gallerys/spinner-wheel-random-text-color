package com.example.spinnerexample;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView spinner;
    private TextView spinnerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        spinnerText = findViewById(R.id.spinnerText);
    }

    public void spinWheel(View view) {
        // Disable clicking during animation
        spinner.setClickable(false);

        // Rotate the spinner image
        float randomRotation = new Random().nextFloat() * 360;
        spinner.animate().rotationBy(3600 + randomRotation).setDuration(3000).start();

        // Generate a random color for the background
        int randomColor = Color.rgb(new Random().nextInt(256), new Random().nextInt(256), new Random().nextInt(256));
        spinnerText.setBackgroundColor(randomColor);

        // Simulate a background task with a delay
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // Enable clicking after the animation
                spinner.setClickable(true);
            }
        }, 3000); // 3000 milliseconds (3 seconds) delay
    }
}
