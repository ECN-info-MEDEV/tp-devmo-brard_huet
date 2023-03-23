package com.example.justeacote.command;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.justeacote.R;
import com.example.justeacote.ReserveActivity;


public class CommandActivity extends AppCompatActivity {
    private CommandAdapter adapter;
    private RecyclerView mCommandRecyclerView;
    public static final int NEW_USER_ACTIVITY_REQUEST_CODE = 1;
    private CommandViewModel mCommandViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_command);


        // Recycler View
        mCommandRecyclerView = findViewById(R.id.recyclerView);
        adapter = new CommandAdapter(new CommandAdapter.CommandDiff(), this);
        mCommandRecyclerView.setHasFixedSize(true);
        mCommandRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mCommandRecyclerView.setAdapter(adapter);


        mCommandViewModel = new ViewModelProvider(this).get(CommandViewModel.class);

        mCommandViewModel.getAllCommands().observe(this, commands -> {
            adapter.submitList(commands);
        });

        ProducteurViewModel mProducteurViewModel = new ViewModelProvider(this).get(ProducteurViewModel.class);

        mProducteurViewModel.getAllProducteurs().observe(this, producteurs -> {
            System.out.println(producteurs);
        });
    }

    public void goToCommand(int commandId) {
        Intent intent = new Intent(CommandActivity.this, ReserveActivity.class);
        intent.putExtra("commandId", commandId);
        startActivity(intent);
    }

    public int getCommandImageFromLabel(String pictureLabel) {
        int id = this.getResources().getIdentifier(pictureLabel, "drawable", this.getPackageName());
        if (id == 0) {
            id = R.drawable.juspomme;
        }
        return id;
    }
}