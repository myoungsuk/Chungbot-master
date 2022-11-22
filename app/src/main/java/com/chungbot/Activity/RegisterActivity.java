package com.chungbot.Activity;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.chungbot.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity
{

    private static LottieAnimationView register;
    private FirebaseUser user;
    private FirebaseDatabase database;
    private Uri imageUri;
    private ProgressBar progressBar;
    private EditText emailEditText, passwordEditText, passwordCheckEditText, et_registration_name;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        FirebaseAuth auth = FirebaseAuth.getInstance();

        ImageButton btnSignIn = findViewById(R.id.signUpButton);
        Button btnGotoLogin = findViewById(R.id.gotoLoginButton);
        EditText emailEditText = findViewById(R.id.emailEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        EditText passwordCheckEditText = findViewById(R.id.passwordCheckEditText);
        EditText nameEditText = findViewById(R.id.et_registration_name);

        btnGotoLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });



        btnSignIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                if(!emailEditText.getText().toString().equals("") && !passwordEditText.getText().toString().equals("")){
                    //이메일과 비밀번호가 공백이 아닌 경우

                }
            }
        });
    }






}