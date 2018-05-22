package com.example.shiva.jarvis;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class ChatFragment extends android.app.Fragment {

    public ChatFragment() {
        // Required empty public constructor
    }

    List<ChatMessage> chatMessageList = new ArrayList<>();
    LinearLayout linearLayout;
    EditText typeMessage;
    ImageButton sendButton;
    CustomAdapter customAdapter;
    RecyclerView recyclerView;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        linearLayout = (LinearLayout) getView().findViewById(R.id.outer);
         //chatMessageList = new ArrayList<>();
         typeMessage = (EditText)linearLayout.findViewById(R.id.include_type_message);
        sendButton = (ImageButton)linearLayout.findViewById(R.id.include_button);
        recyclerView = (RecyclerView)linearLayout.findViewById(R.id.include_recycler);

        customAdapter = new CustomAdapter(chatMessageList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(customAdapter);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(typeMessage.getText().toString())) {
                    Toast.makeText(getActivity(), "Type a message", Toast.LENGTH_SHORT).show();
                    return;
                }
                String myMessage = typeMessage.getText().toString();
                sendMessage(myMessage);


                getReply();



            }


        });

    }

    private void getReply() {
        String s = "Under construction";
        String hh = String.valueOf(Calendar.getInstance().get(Calendar.HOUR));
        String mm = String.valueOf(Calendar.getInstance().get(Calendar.MINUTE));
        ChatMessage chatMessage = new ChatMessage(hh+":"+mm, s, false);
        chatMessageList.add(chatMessage);
        customAdapter.notifyDataSetChanged();
        typeMessage.setText("");
        recyclerView.scrollToPosition(chatMessageList.size()-1);

    }

    private void sendMessage(String myMessage) {
        //Log.d("message",myMessage);
        Toast.makeText(getActivity(), "fun "+myMessage, Toast.LENGTH_SHORT).show();
        String hh = String.valueOf(Calendar.getInstance().get(Calendar.HOUR));
        String mm = String.valueOf(Calendar.getInstance().get(Calendar.MINUTE));
        ChatMessage chatMessage = new ChatMessage(hh+":"+mm, myMessage, true);
        chatMessageList.add(chatMessage);
        customAdapter.notifyDataSetChanged();
        recyclerView.scrollToPosition(chatMessageList.size()-1);

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false);

    }





}
