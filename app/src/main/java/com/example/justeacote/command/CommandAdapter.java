package com.example.justeacote.command;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.justeacote.R;

import java.util.List;

public class CommandAdapter extends ListAdapter<CommandData, CommandViewHolder> {
    private List<CommandData> commandData;
    private CommandActivity activity;

    public CommandAdapter(@NonNull DiffUtil.ItemCallback<CommandData> diffCallBack, CommandActivity activity) {
        super(diffCallBack);
        this.activity = activity;
    }

    @NonNull
    @Override
    public CommandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return CommandViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull CommandViewHolder holder, int position) {
        CommandData current = getItem(position);
        holder.bind(current, activity);
    }

    static class CommandDiff extends DiffUtil.ItemCallback<CommandData> {
        @Override
        public boolean areItemsTheSame(@NonNull CommandData oldItem, @NonNull CommandData newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull CommandData oldItem, @NonNull CommandData newItem) {
            return oldItem.equals(newItem);
        }
    }
}
