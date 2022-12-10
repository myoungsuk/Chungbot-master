package com.chungbot.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chungbot.Activity.AddNoticeActivity;
import com.chungbot.Activity.ChatbotActivity;
import com.chungbot.R;

public class NoticeFragment extends Fragment
{
    Activity activity = getActivity();

    private Button addButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v=inflater.inflate(R.layout.fragment_notice,container,false);
        // Inflate the layout for this fragment
        addButton = (Button) v.findViewById(R.id.addFloatingButton);



        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddNoticeActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }
}