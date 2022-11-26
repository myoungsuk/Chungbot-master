package com.chungbot.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.chungbot.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity
{

    ImageButton LoginButton;
    Button SignupButton;
    Button passwordResetButton;
    EditText emailEditText;
    EditText passwordEditText;
    private ProgressBar progressBar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        LoginButton = (ImageButton) findViewById(R.id.loginButton);
        SignupButton = findViewById(R.id.signUpButton);
        passwordResetButton = findViewById(R.id.gotoPasswordResetButton);

        emailEditText = (EditText) findViewById(R.id.emailEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        auth = FirebaseAuth.getInstance();


        initLoginButton();

        passwordResetButton.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(LoginActivity.this, PasswordResetActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        SignupButton.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void initLoginButton()
    {

        LoginButton = (ImageButton) findViewById(R.id.loginButton);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        auth = FirebaseAuth.getInstance();

        LoginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                if (auth != null)
                {
                    auth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>()
                            {

                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task)
                                {
                                    if (task.isSuccessful())
                                    {
                                        progressBar.setVisibility(View.GONE);
                                        Toast.makeText(LoginActivity.this, "로그인에 성공했습니다", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(intent);

                                        finish();
                                    } else
                                    {
                                        Toast.makeText(LoginActivity.this, "로그인 오류", Toast.LENGTH_SHORT).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                }
                            });
                }

            }
        });
    }
}