package com.example.justeacote.command;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {CommandData.class}, version = 1, exportSchema = false)
public abstract class CommandRoomDatabase extends RoomDatabase {
    public abstract CommandDao commandDao();

    private static volatile CommandRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static CommandRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CommandRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), CommandRoomDatabase.class, "database").build();
                }
            }
        }
        return INSTANCE;
    }
}
