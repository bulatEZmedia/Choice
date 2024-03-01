package com.example.mychoiceai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    Context context;
    ArrayList<MessageModel> modelArrayList;

    public MessageAdapter(Context context, ArrayList<MessageModel> modelArrayList){
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public MessageAdapter.MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.message_list, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.MessageViewHolder holder, int position) {
        MessageModel messageModel = modelArrayList.get(position);
        holder.message_title.setText(messageModel.message);
        holder.date_title.setText(messageModel.date);
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder{
        TextView message_title;
        TextView date_title;

        public MessageViewHolder(@NonNull View itemView){
            super(itemView);
            date_title = itemView.findViewById(R.id.date_item);
            message_title = itemView.findViewById(R.id.message_item);
        }
    }
}
