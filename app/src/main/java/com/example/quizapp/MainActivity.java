package com.example.quizapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    public int points = 0;
    public int point1 = 0;
    public int point2 = 0;
    public int point3 = 0;
    public int point4 = 0;
    public int point5 = 0;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button prev = findViewById(R.id.prev);
        Button next = findViewById(R.id.next);

        final ViewFlipper viewFlipper = findViewById(R.id.viewflipper);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showNext();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showPrevious();
            }
        });

        RadioGroup radioGroup1 = findViewById(R.id.question1);
        RadioGroup radioGroup2 = findViewById(R.id.question2);
        RadioGroup radioGroup3 = findViewById(R.id.question3);
        RadioGroup radioGroup4 = findViewById(R.id.question4);
        RadioGroup radioGroup5 = findViewById(R.id.question5);

        radioGroup1.clearCheck();
        radioGroup2.clearCheck();
        radioGroup3.clearCheck();
        radioGroup4.clearCheck();
        radioGroup5.clearCheck();


        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup arg0, int id) {
                if(id == R.id.correctq1) {
                    point1 = 10;
                }

                points = point1 + point2 + point3 + point4 + point5;
            }
        });

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup arg0, int id) {
                if(id == R.id.correct2q2) {
                    point2 = 10;
                }

                points = point1 + point2 + point3 + point4 + point5;

            }
        });

        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup arg0, int id) {
                if(id == R.id.correct2q3) {
                    point3 = 10;
                }

                points = point1 + point2 + point3 + point4 + point5;

            }
        });

        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup arg0, int id) {
                if(id == R.id.correctq4) {
                    point4 = 10;
                }

                points = point1 + point2 + point3 + point4 + point5;

            }
        });

        radioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup arg0, int id) {
                if(id == R.id.correctq5) {
                    point5 = 10;
                }
                points = point1 + point2 + point3 + point4 + point5;

            }
        });

    }

    public void goToSubmitted(View view){

        Intent intent = new Intent(MainActivity.this, Submitted.class);

        Bundle bundle = new Bundle();

        String point = Integer.toString(points);

        bundle.putString("score",point);
        intent.putExtras(bundle);

        startActivity(intent);

    }
}
