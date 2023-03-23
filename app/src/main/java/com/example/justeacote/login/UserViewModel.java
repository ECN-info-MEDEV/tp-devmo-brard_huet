package com.example.justeacote.login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepository userRepository;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }

    public User getConnexionInfo(String username, String password) { return userRepository.getConnexionInfo(username, password); }

    public void insert(User user) { userRepository.insert(user); }
}
