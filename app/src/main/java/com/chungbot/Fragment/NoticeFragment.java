package com.chungbot.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.chungbot.Activity.AddNoticeActivity;
import com.chungbot.R;
import com.chungbot.models.NoticeItem;

import java.util.ArrayList;

public class NoticeFragment extends Fragment
{
    Activity activity = getActivity();

    private ArrayList<String> noticeList;
    private RecyclerView mRecyclerView;
    private NoticeRecyclerViewAdapter mRecyclerViewAdapter;

    private Button addButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v=inflater.inflate(R.layout.fragment_notice,container,false);
        // Inflate the layout for this fragment

        noticeList = new ArrayList<>();
        //임시
        for (int i=0; i<100; i++) {
            noticeList.add(String.format("TEXT %d", i)) ;
        }

        mRecyclerView = v.findViewById(R.id.articleRecyclerView);
        mRecyclerViewAdapter = new NoticeRecyclerViewAdapter(noticeList);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

//        addButton = (Button) v.findViewById(R.id.addFloatingButton);
//
//
//        addButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), AddNoticeActivity.class);
//                startActivity(intent);
//            }
//        });

        return v;
    }
}

class NoticeRecyclerViewAdapter extends RecyclerView.Adapter<NoticeRecyclerViewAdapter.ViewHolder> {
    private ArrayList<String> noticeList;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.notice_item);
        }
    }

    public NoticeRecyclerViewAdapter(ArrayList<String> noticeList) {
        this.noticeList = noticeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notice, parent, false);

        return new NoticeRecyclerViewAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String text = noticeList.get(position);
        holder.title.setText(text);
    }

    @Override
    public int getItemCount() {
        return noticeList.size();
    }
}