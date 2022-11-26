package com.chungbot.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chungbot.R;

public class NoticeFragment extends Fragment
{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v=inflater.inflate(R.layout.fragment_notice,container,false);
        // Inflate the layout for this fragment
        return v;
    }
}