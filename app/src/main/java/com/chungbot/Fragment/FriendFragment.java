package com.chungbot.Fragment;

import static androidx.core.content.ContentProviderCompat.requireContext;
import static java.security.AccessController.getContext;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chungbot.Activity.ChatbotActivity;
import com.chungbot.Friend;
import com.chungbot.R;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class FriendFragment extends Fragment
{
    private ArrayList<Friend> friendList;
    private DatabaseReference mDatabase;
    private FirebaseAuth auth;
    private Uri imageUri;
    private StorageReference firebaseStorage;
    private FirebaseUser user;
    private String uid;

    private RecyclerView recyclerview;
    private RecyclerViewAdapter mRecyclerAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_friend, container, false);
        // Inflate the layout for this fragment
        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        firebaseStorage = FirebaseStorage.getInstance().getReference();
        user = auth.getCurrentUser();
        uid = user.getUid();

        friendList = new ArrayList<>();
        recyclerview = v.findViewById(R.id.friendRecyclerView);
        mRecyclerAdapter = new RecyclerViewAdapter(friendList);
        recyclerview.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerview.setAdapter(mRecyclerAdapter);


        // mRecyclerAdapter.setFriendList(friendList);

        return v;
    }

}

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>
{
    private ArrayList<Friend> friendList;

    private DatabaseReference mDatabase;
    private FirebaseAuth auth;
    private Uri imageUri;
    private StorageReference firebaseStorage;
    private FirebaseUser user;
    private String uid;
    private RecyclerView recyclerview;
    private RecyclerViewAdapter mRecyclerAdapter;
    AlertDialog.Builder alertDialog;

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView friendname, friendemail;
        public ImageView friendprofile;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            friendname = itemView.findViewById(R.id.friend_item_tv);
            friendemail = itemView.findViewById(R.id.friend_item_email);
            friendprofile = itemView.findViewById(R.id.friend_item_iv);

        }
    }

    public RecyclerViewAdapter(ArrayList<Friend> list)
    {
        this.friendList = list;
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        uid = user.getUid();

        FirebaseDatabase.getInstance().getReference().child("Users").addValueEventListener(new ValueEventListener()
        {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                list.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    Friend item = dataSnapshot.getValue(Friend.class);
                    list.add(item);
                }
                notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

            }
        });

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        Friend friend = friendList.get(position);
        if (friend.profileImageUrl.equals(""))
        {

        } else
        {
            Glide.with(holder.itemView.getContext())
                    .load(friendList.get(position).profileImageUrl)
                    .apply(new RequestOptions().circleCrop())
                    .into(holder.friendprofile);
        }
        holder.friendname.setText(friendList.get(position).name);
        holder.friendemail.setText(friendList.get(position).email);

        String holderPhoto = friend.profileImageUrl;
        String holderName = friend.name;
        String holderEmail = friend.email;
//
        String AdapterUid = friend.uid;

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                alertDialog = new AlertDialog.Builder(holder.itemView.getContext());
                alertDialog.setView(R.layout.profile_dialog);
                final AlertDialog dialog = alertDialog.create();
                dialog.show();

                dialog.setCanceledOnTouchOutside(false);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                ImageView photoImage = dialog.findViewById(R.id.iv_circle_image);
                TextView emailText = dialog.findViewById(R.id.tv_text2);
                TextView nameText = dialog.findViewById(R.id.tv_text1);
                MaterialButton cancleButton = dialog.findViewById(R.id.btn_cancel);
                MaterialButton messageButton = dialog.findViewById(R.id.btn_call);

                emailText.setText(holderEmail);
                nameText.setText(holderName);

                Glide.with(holder.itemView.getContext())
                        .load(holderPhoto)
                        .apply(new RequestOptions().circleCrop())
                        .into(photoImage);

                cancleButton.setOnClickListener(new View.OnClickListener()
                {

                    @Override
                    public void onClick(View view)
                    {
                        dialog.dismiss();
                    }
                });

                messageButton.setOnClickListener(new View.OnClickListener()
                {

                    @Override
                    public void onClick(View view)
                    {
                        //Todo ???????????? ????????????
//                        Intent intent = new Intent(getActivity(), MessageActivity.class);
//                        intent.putExtra("destinationUid", AdapterUid);
//                        startActivity(intent);
                    }
                });
            }
        });

    }
//
//            coolDialog.setCallButtonOnClickListener()  {
//                val intent = Intent(context, MessageActivity::class.java)
//                intent.putExtra("destinationUid", adapteruid)
//                context?.startActivity(intent)
//            }
//            coolDialog.setCancelButtonOnClickListener() {
//                Toast.makeText(requireContext(), "??????????????????.", Toast.LENGTH_SHORT).show()
//                coolDialog.dismiss()
//            }
//
//            coolDialog.show()

//


    @Override
    public int getItemCount()
    {
        return friendList.size();
    }
}
