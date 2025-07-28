package com.example.calculatebmi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculate);

        // Receive data from intent
        Intent dataIntent = getIntent();
        double BMI = dataIntent.getDoubleExtra("score", 0.0);
        double HI = dataIntent.getDoubleExtra("HI", 0.0);
        double HF = dataIntent.getDoubleExtra("HF", 0.0);
        double CM = dataIntent.getDoubleExtra("CM", 0.0);
        double miter = dataIntent.getDoubleExtra("miter", 0.0);
        double Weight = dataIntent.getDoubleExtra("Weight", 0.0);
        int age = dataIntent.getIntExtra("age", 0);
        String gender = dataIntent.getStringExtra("Gender");

        // Delay 3 seconds before moving to Result
        new Handler().postDelayed(() -> {
            Intent resultIntent = new Intent(CalculateActivity.this, Result.class);

            resultIntent.putExtra("score", BMI);
            resultIntent.putExtra("HI", HI);
            resultIntent.putExtra("HF", HF);
            resultIntent.putExtra("CM", CM);
            resultIntent.putExtra("miter", miter);
            resultIntent.putExtra("Weight", Weight);
            resultIntent.putExtra("age", age);
            resultIntent.putExtra("Gender", gender);

            startActivity(resultIntent);
            finish();
        }, 2500);
    }
}