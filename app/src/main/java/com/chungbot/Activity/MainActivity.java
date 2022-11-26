package com.chungbot.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.chungbot.Fragment.ChatFragment;
import com.chungbot.Fragment.FriendFragment;
import com.chungbot.Fragment.HomeFragment;
import com.chungbot.Fragment.NoticeFragment;
import com.chungbot.Fragment.SettingFragment;
import com.chungbot.Friend;
import com.chungbot.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "Main_Activity";
    private BottomNavigationView mBottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigationView=findViewById(R.id.bottomNavigationView);

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer,new HomeFragment()).commit();

        //case 함수를 통해 클릭 받을 때마다 화면 변경하기
        mBottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener()  {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {

                switch (item.getItemId()){
                    case R.id.home :
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new HomeFragment()).commit();
                        break;
                    case R.id.friend:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new FriendFragment()).commit();
                        break;
                    case R.id.chat:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new ChatFragment()).commit();
                        break;
                    case R.id.notice :
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new NoticeFragment()).commit();
                        break;
                    case R.id.settings :
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new SettingFragment()).commit();
                        break;
                }
                return true;
            }
        });
    }
}