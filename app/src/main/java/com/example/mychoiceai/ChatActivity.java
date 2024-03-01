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
    ImageView buttonSend, lightning;
    TextView motivation, plan, progress, history;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        lightning = findViewById(R.id.imageView54);
        message = findViewById(R.id.message);
        buttonSend = findViewById(R.id.sendMessage);
        motivation = findViewById(R.id.textView73);
        plan = findViewById(R.id.textView74);
        progress = findViewById(R.id.textView72);
        history = findViewById(R.id.textView75);

        motivation.setVisibility(View.GONE);
        plan.setVisibility(View.GONE);
        progress.setVisibility(View.GONE);
        history.setVisibility(View.GONE);

        lightning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                motivation.setVisibility(View.VISIBLE);
                plan.setVisibility(View.VISIBLE);
                progress.setVisibility(View.VISIBLE);
                history.setVisibility(View.VISIBLE);
            }
        });




        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager=
                new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false  );
        layoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(layoutManager);
        modelArrayList = new ArrayList<>();
        messageAdapter = new MessageAdapter(this, modelArrayList);
        recyclerView.setAdapter(messageAdapter);




        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateFormat dateFormat = new SimpleDateFormat("HH:mm");
                Date date = new Date();
                String dateNow = dateFormat.format(date);
                String messageSent = message.getText().toString().trim();
                MessageModel messageModel = new MessageModel(messageSent, dateNow);
                modelArrayList.add(messageModel);
            }
        });

        motivation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateFormat dateFormat = new SimpleDateFormat("HH:mm");
                Date date = new Date();
                String dateNow = dateFormat.format(date);
                String text = motivation.getText().toString().trim();
                MessageModel messageModel = new MessageModel(text, dateNow);
                modelArrayList.add(messageModel);
                motivation.setVisibility(View.GONE);
                plan.setVisibility(View.GONE);
                progress.setVisibility(View.GONE);
                history.setVisibility(View.GONE);
            }
        });
        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateFormat dateFormat = new SimpleDateFormat("HH:mm");
                Date date = new Date();
                String dateNow = dateFormat.format(date);
                String text = plan.getText().toString().trim();
                MessageModel messageModel = new MessageModel(text, dateNow);
                modelArrayList.add(messageModel);
                motivation.setVisibility(View.GONE);
                plan.setVisibility(View.GONE);
                progress.setVisibility(View.GONE);
                history.setVisibility(View.GONE);
            }
        });
        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateFormat dateFormat = new SimpleDateFormat("HH:mm");
                Date date = new Date();
                String dateNow = dateFormat.format(date);
                String text = progress.getText().toString().trim();
                MessageModel messageModel = new MessageModel(text, dateNow);
                modelArrayList.add(messageModel);
                motivation.setVisibility(View.GONE);
                plan.setVisibility(View.GONE);
                progress.setVisibility(View.GONE);
                history.setVisibility(View.GONE);
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateFormat dateFormat = new SimpleDateFormat("HH:mm");
                Date date = new Date();
                String dateNow = dateFormat.format(date);
                String text = history.getText().toString().trim();
                MessageModel messageModel = new MessageModel(text, dateNow);
                modelArrayList.add(messageModel);
                motivation.setVisibility(View.GONE);
                plan.setVisibility(View.GONE);
                progress.setVisibility(View.GONE);
                history.setVisibility(View.GONE);
            }
        });


        messageAdapter.notifyDataSetChanged();




    }
}