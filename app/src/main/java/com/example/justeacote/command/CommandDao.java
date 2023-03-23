package com.example.justeacote.command;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CommandDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(CommandData command);

    @Insert(onConflict= OnConflictStrategy.IGNORE)
    void insertProducteur(ProducteurData producteur);

    @Query("DELETE FROM command")
    void deleteAll();

    @Query("SELECT * FROM command ORDER BY commandName ASC")
    LiveData<List<CommandData>> getAlphabetizedCommand();

    @Query("SELECT * FROM producteur ORDER BY prenom ASC")
    LiveData<List<ProducteurData>> getAlphabetizedProducteurs();
}
