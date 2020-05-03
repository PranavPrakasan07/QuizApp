package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.TextView;

public class Submitted extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submitted);

        ConstraintLayout constraintLayout = findViewById(R.id.submittedlayout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        TextView textView = findViewById(R.id.score);

        Bundle bundle = getIntent().getExtras();

        assert bundle != null;

        String score = bundle.getString("score");

        textView.setText(score);

    }
}
