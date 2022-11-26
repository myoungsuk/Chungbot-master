package com.chungbot.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.airbnb.lottie.LottieAnimationView;
import com.chungbot.Activity.ChatbotActivity;
import com.chungbot.R;

public class HomeFragment extends Fragment
{
    private LottieAnimationView accessButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v=inflater.inflate(R.layout.fragment_home,container,false);
        // Inflate the layout for this fragment
        accessButton = (LottieAnimationView) v.findViewById(R.id.accessButton);

        accessButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getActivity(), ChatbotActivity.class);
                startActivity(intent);


            }
        });
        return v;


    }
}