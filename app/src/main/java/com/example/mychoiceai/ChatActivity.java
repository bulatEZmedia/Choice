package com.example.mychoiceai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ChatActivity extends AppCompatActivity {


    EditText message;
    RecyclerView recyclerView;
    ArrayList<MessageModel> modelArrayList;
    MessageAdapter messageAdapter;
    ImageView buttonSend;
    Button button;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        message = findViewById(R.id.message);
        buttonSend = findViewById(R.id.sendMessage);
        textView = findViewById(R.id.textView71);


        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        modelArrayList = new ArrayList<>();
        messageAdapter = new MessageAdapter(this, modelArrayList);
        recyclerView.setAdapter(messageAdapter);
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        textView.setText(dateFormat.format(date));



        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String messageSent = message.getText().toString().trim();
                MessageModel messageModel = new MessageModel(messageSent);
                modelArrayList.add(messageModel);
            }
        });
        messageAdapter.notifyDataSetChanged();




    }
}