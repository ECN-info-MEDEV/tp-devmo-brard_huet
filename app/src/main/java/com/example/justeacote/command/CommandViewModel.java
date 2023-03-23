package com.example.justeacote.command;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CommandViewModel extends AndroidViewModel {
    private CommandRepository mRepository;
    private final LiveData<List<CommandData>> mAllCommands;
    public CommandViewModel(Application application) {
            super(application);
            mRepository = new CommandRepository(application);
            mAllCommands = mRepository.getAllCommands();
    }

    public LiveData<List<CommandData>> getAllCommands() {return mAllCommands;}

    public LiveData<List<CommandData>> getCommandById(int id) {return mRepository.getCommandById(id);}

    public void insert(CommandData command) { mRepository.insert(command); }
}
