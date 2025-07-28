package com.example.calculatebmi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.calculatebmi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    String gender = "male"; // default


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String ageStr = binding.age.getText().toString().trim();
                String HFStr = binding.heightft.getText().toString().trim();
                String WeightStr = binding.weight.getText().toString().trim();

                if (ageStr.isEmpty()) {

                    binding.age.setError("Please Enter Age");



                } else if (HFStr.isEmpty()) {

                    binding.heightft.setError("Enter Height");


                } else if (WeightStr.isEmpty()) {


                    binding.weight.setError("Enter Weight");

                } else {


                    int age = Integer.parseInt(binding.age.getText().toString());
                    double HF = Double.parseDouble(binding.heightft.getText().toString());
                    double weight = Double.parseDouble(binding.weight.getText().toString());

                    // convert inches

                    double totalIn = HF * 12;

                    //--------------------------------

                    // convert inches to centimeters---------

                    double totalcm = totalIn * 2.54;

                    //---------------------------------------

                    //convert cm to meter-------------------

                    double totalM = totalcm / 100;

                    //--------------------------------------

                    double BMI = weight / (totalM * totalM);



                    Intent intent = new Intent(MainActivity.this, CalculateActivity.class);


                    intent.putExtra("score", BMI);
                    intent.putExtra("HI", totalIn);
                    intent.putExtra("HF", HF);
                    intent.putExtra("CM", totalcm);
                    intent.putExtra("miter", totalM);
                    intent.putExtra("Weight", weight);
                    intent.putExtra("age", age);
                    intent.putExtra("Gender", gender);


                    startActivity(intent);
                }


            }


        });


        ;

        binding.profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, profile.class);
                startActivity(intent);
            }
        });


        binding.mail.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {

                gender = "Male";

                binding.femaile.setBackgroundColor(Color.WHITE);
                binding.mail.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.blue));


            }
        });

        binding.femaile.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {

                gender = "Female";


                binding.mail.setBackgroundColor(Color.WHITE);
                binding.femaile.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.blue));
            }
        });


    }
}