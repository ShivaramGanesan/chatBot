package com.example.shiva.jarvis;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by shiva on 12/22/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<ChatMessage> mList;
    private  static final int MY_MESSAGE = 1;
    private static final int BOT_MESSAGE = 0;


    public class ViewHolder1 extends RecyclerView.ViewHolder{
        TextView myMessage,myTime;
        public ViewHolder1(View itemView) {
            super(itemView);
            myMessage = (TextView)itemView.findViewById(R.id.my_message);
            myTime = (TextView)itemView.findViewById(R.id.my_time);
        }
    }
    public class ViewHolder2 extends RecyclerView.ViewHolder{
        TextView botMessage,botTime;
        public ViewHolder2(View itemView) {
            super(itemView);
            botMessage = (TextView)itemView.findViewById(R.id.bot_message);
            botTime = (TextView)itemView.findViewById(R.id.bot_time);
        }
    }
    public CustomAdapter (List<ChatMessage> mList){
        this.mList = mList;
    }

    @Override
    public int getItemViewType(int position) {
        ChatMessage chatMessage = mList.get(position);
        if(chatMessage.isMine() == true)
            return MY_MESSAGE;
        else
            return BOT_MESSAGE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        if(viewType == MY_MESSAGE){
            v = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.display_my_messages, parent, false);
            return new ViewHolder1(v);
        }
        else{
            v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.bot_message, parent, false);
            return new ViewHolder2(v);

        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ChatMessage chatMessage = mList.get(position);
        switch (holder.getItemViewType()){
            case 1:
                ViewHolder1 viewHolder1 = (ViewHolder1)holder;
                ((ViewHolder1) holder).myMessage.setText(chatMessage.getMessage());
                ((ViewHolder1) holder).myTime.setText(chatMessage.getTime());
                break;
            case 0:
                ViewHolder2 viewHolder2 = (ViewHolder2)holder;
                ((ViewHolder2) holder).botMessage.setText(chatMessage.getMessage());
                ((ViewHolder2) holder).botTime.setText(chatMessage.getTime());
                break;

        }
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }
}
