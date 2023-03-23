package com.example.justeacote.command;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CommandRepository {
    private CommandDao mCommandDao;
    private LiveData<List<CommandData>> mAllCommands;

    CommandRepository(Application application) {
        CommandRoomDatabase db = CommandRoomDatabase.getDatabase(application);
        mCommandDao = db.commandDao();
        mAllCommands = mCommandDao.getAlphabetizedCommand();
    }

    LiveData<List<CommandData>> getAllCommands() {
        return mAllCommands;
    }

    void insert(CommandData commandData) {
        CommandRoomDatabase.databaseWriteExecutor.execute(() -> {
            mCommandDao.insert(commandData);
        });
    }
}
