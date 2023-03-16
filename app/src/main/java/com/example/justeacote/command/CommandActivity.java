package com.example.justeacote.command;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.justeacote.R;

import java.util.LinkedList;

public class CommandActivity extends AppCompatActivity {
    CommandAdapter adapter;
    RecyclerView mCommandRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_command);

        // Recycler View
        mCommandRecyclerView = findViewById(R.id.recyclerView);
        adapter = new CommandAdapter(new LinkedList<>());
        mCommandRecyclerView.setHasFixedSize(true);
        mCommandRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mCommandRecyclerView.setAdapter(adapter);


    }
    public int getCommandImageFromLabel(String pictureLabel) {
        int id = getResources().getIdentifier(pictureLabel, "drawable", getPackageName());
        if (id == 0) {
            id = R.drawable.juspomme;
        }
        return id;
    }
}