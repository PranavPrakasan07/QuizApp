package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText email = findViewById(R.id.email);
        final EditText name = findViewById(R.id.name);
        final EditText password = findViewById(R.id.password);

        Button signup = findViewById(R.id.signup);

        mAuth = FirebaseAuth.getInstance();



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameText = name.getText().toString();
                String emailText = email.getText().toString();
                String passwordText = password.getText().toString();

                if(TextUtils.isEmpty(emailText) || TextUtils.isEmpty(passwordText)){
                    Toast.makeText(RegisterActivity.this, "Please enter credentials", Toast.LENGTH_SHORT).show();
                }

                if(passwordText.length()<6){
                    Toast.makeText(RegisterActivity.this, "Password too short", Toast.LENGTH_SHORT).show();
                }

                else{
                mAuth.createUserWithEmailAndPassword(emailText,passwordText)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                    finish();
                                }
                                else{
                                    Toast.makeText(getApplicationContext(),"E-mail or password is wrong",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                }
            }
        });
    }
}