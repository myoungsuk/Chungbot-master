package com.chungbot.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.chungbot.MainActivity;
import com.chungbot.R;

public class LoginActivity extends AppCompatActivity
{
    private TextView LoginText;
    private static ImageButton LoginButton;
    private static Button SignupButton;
    private static Button passwordResetButton;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        LoginButton = findViewById(R.id.loginButton);
        SignupButton = findViewById(R.id.signUpButton);
        passwordResetButton = findViewById(R.id.gotoPasswordResetButton);


       passwordResetButton.setOnClickListener(new View.OnClickListener() {

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

        LoginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

//    //로그인 버튼 함수
//    private fun initLoginButton()
//    {
//
//        val loginButton = findViewById<LottieAnimationView>(R.id.loginButton)
//                val logintext = findViewById<TextView>(R.id.loginText)
//            loginButton?.setOnClickListener {
//
//        //변수 선언
//        val email = (findViewById<View>(R.id.emailEditText) as EditText).text.toString()
//        val password = (findViewById<View>(R.id.passwordEditText) as EditText).text.toString()
//
//        showProgress()
//        //firebase 리스너 호출
//        if (email.isNotEmpty() && password.isNotEmpty())
//        {
//
//
//            auth.signInWithEmailAndPassword(email, password)
//                    .addOnCompleteListener(this) { task ->
//                hideProgress()
//            if (task.isSuccessful)
//            {
//
//                Toast.makeText(
//                        this,
//                        "로그인에 성공하셨습니다", Toast.LENGTH_SHORT
//                ).show()
//                hideProgress()
//                myStartActivity(MainActivity::class.java)
//            } else
//            {
//
//                Toast.makeText(
//                        this,
//                        "로그인에 실패했습니다. 이메일 또는 비밀번호를 확인해 주세요", Toast.LENGTH_SHORT
//                ).show()
//
//                hideProgress()
//            }
//
//
//        }
//        } else
//        {
//
//            Toast.makeText(
//                    this,
//                    "이메일 또는 비밀번호를 입력해 주세요.", Toast.LENGTH_SHORT
//            ).show()
//
//            hideProgress()
//        }
//
//    }
//    }
//
//    private fun showProgress() {
//        findViewById<ProgressBar>(R.id.progressBar)?.isVisible = true
//    }
//
//    private fun hideProgress() {
//        findViewById<ProgressBar>(R.id.progressBar)?.isVisible = false
//    }
//
//    // 액티비티 이동
//    private fun myStartActivity(c: Class<*>)
//    {
//        val intent = Intent(this, c)
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//        startActivity(intent)
//    }

    }


}