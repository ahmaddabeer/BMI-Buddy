package com.example.calculatebmi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.calculatebmi.databinding.ActivityResultBinding;

public class Result extends AppCompatActivity {


    ActivityResultBinding binding;


    @SuppressLint({"MissingInflatedId", "DefaultLocale", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent data = getIntent();

        double text = data.getDoubleExtra("score", 0.0);
        String str = String.format("%.2f", text);
        binding.score.setText(str);

        //classification batana ha
        if (text < 18.5) {
            binding.scoreIntext.setText("Underweight");
            binding.scoreIntext.setTextColor(ContextCompat.getColor(this, R.color.under));
        } else if (text >= 18.5 && text <= 24.9) {
            binding.scoreIntext.setText("Normal");
            binding.scoreIntext.setTextColor(ContextCompat.getColor(this, R.color.normal));
        } else if (text >= 25.0 && text <= 29.9) {
            binding.scoreIntext.setText("Overweight");
            binding.scoreIntext.setTextColor(ContextCompat.getColor(this, R.color.overweight));
        } else {
            binding.scoreIntext.setText("Obese");
            binding.scoreIntext.setTextColor(ContextCompat.getColor(this, R.color.Obese));
        }



        //set text in inc box
        //--------------------------------------------------------------

        double heightInInch = data.getDoubleExtra("HI", 0.0);
        String HI = String.format("%.2f",heightInInch);

        binding.hi.setText(HI);
        //----------------------------------------------------------------

        //set text in fit
        //-------------------------------------------------------------

        double heightInfit = data.getDoubleExtra("HF", 0.0);
        String HF = String.format("%.2f",heightInfit);

        binding.hf.setText(HF);

        //-------------------------------------------------------------

        //set text in weight
        //-----------------------------------------------------------
        double weight = data.getDoubleExtra("Weight", 0.0);
        String Weight = String.format("%.1f", weight); // show nicely

        binding.we.setText(Weight);

        //------------------------------------------------------------

        //totalcm set in cm box
        //-----------------------------------------------------------

        double totalcm = data.getDoubleExtra("CM", 0.0);
        String totalCM = String.format("%.2f", totalcm);
        binding.hcm.setText(totalCM);

        //total miter set in miter box
        //--------------------------------------------------------------

        double totalmeter = data.getDoubleExtra("miter", 0.0);
        String totalM = String.format("%.2f", totalmeter);
        binding.hm.setText(totalM);

        //age ---------------

        int age = data.getIntExtra("age",0);
        String Age = String.valueOf(age);
        binding.age.setText(Age);

        // set gender ---------------------------

        String gender = data.getStringExtra("Gender");
        binding.gen.setText(gender);


        binding.resultToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });


    }
}