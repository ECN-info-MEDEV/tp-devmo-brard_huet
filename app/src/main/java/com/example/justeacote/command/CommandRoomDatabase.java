package com.example.justeacote.command;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

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
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), CommandRoomDatabase.class, "database").addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                CommandDao dao = INSTANCE.commandDao();
                dao.deleteAll();
                CommandData command = new CommandData(123, "Super commande", "Benoit", "Un super jus de pomme et du jus d'orange", "qq part rue de Verdun");
                dao.insert(command);
                command = new CommandData(321, "Incroyable commande", "", "Ici, vous aurez un jus de raisin fantastique !", "Tout en bas de nantes");
                dao.insert(command);


            });
        }
    };
}
