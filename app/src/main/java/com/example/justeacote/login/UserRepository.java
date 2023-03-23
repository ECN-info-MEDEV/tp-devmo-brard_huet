package com.example.justeacote.login;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.justeacote.command.CommandRoomDatabase;

import java.util.List;

public class UserRepository {

    private UserDao userDao;

    UserRepository(Application application){
        CommandRoomDatabase db = CommandRoomDatabase.getDatabase(application);
        userDao = db.userDao();
    }

    User getConnexionInfo(String username, String password) {
        return userDao.getOneUser(username, password);
    }

    void insert(User user) {
        CommandRoomDatabase.databaseWriteExecutor.execute(() -> {
            userDao.insert(user);
        });
    }
}
