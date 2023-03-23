package com.example.justeacote.login;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

public interface UserDao {

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    void insert (User user);

    @Query("DELETE FROM user")
    void deleteAll();

    @Query("SELECT * FROM user")
    void getAllUser();
}
