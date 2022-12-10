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

    private ArrayList<NoticeItem> noticeList;
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

        // 내용 채우기.
        // 1.네트워크 통신으로 json 객체 받아서, 2.문자열로 변환 후에, 3.noticeList 에 모두 add하기
        noticeList.add(new NoticeItem(1, "제목1", "작성자1", "작성일1", "내용1"));
        noticeList.add(new NoticeItem(2, "제목2", "작성자2", "작성일2", "내용2"));

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
    private ArrayList<NoticeItem> noticeList;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title, writer, date, pre_content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            writer = itemView.findViewById(R.id.writer);
            date = itemView.findViewById(R.id.date);
            pre_content = itemView.findViewById(R.id.pre_content);
        }
    }

    public NoticeRecyclerViewAdapter(ArrayList<NoticeItem> noticeList) {
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
        holder.title.setText(noticeList.get(position).getTitle());
        holder.writer.setText(noticeList.get(position).getWriter());
        holder.date.setText(noticeList.get(position).getTitle());
        holder.pre_content.setText(noticeList.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return noticeList.size();
    }
}