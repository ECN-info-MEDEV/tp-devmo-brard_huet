package com.example.justeacote.login;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    void insert (User user);
    @Query("DELETE FROM user")
    void deleteAll();
    @Query("SELECT * FROM user WHERE user.username = :verifUsername AND user.password = :verifPassword")
    User getOneUser(String verifUsername, String verifPassword);
}
