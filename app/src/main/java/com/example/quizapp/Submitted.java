package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
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
        TextView comment = findViewById(R.id.comment);

        Bundle bundle = getIntent().getExtras();

        assert bundle != null;

        String score = bundle.getString("score");

        textView.setText(score);

        assert score != null;
        int marks = Integer.parseInt(score);

        if(marks <= 20 ){
            comment.setText("A little more work, and you are done... All the best");
        }

        else if(marks <= 30){
            comment.setText("Good work, but you can definitely do better...");
        }

        else if(marks <= 40 ){
            comment.setText("Great job...");
        }

        else{
            comment.setText("Brilliant !");
        }

    }

    public void goToQuiz(View view){

        Intent intent = new Intent(Submitted.this, MainActivity.class);
        startActivity(intent);

    }

}
