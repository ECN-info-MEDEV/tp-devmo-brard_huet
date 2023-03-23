package com.example.justeacote.command;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ProducteurRepository {
    private CommandDao mCommandDao;
    private LiveData<List<ProducteurData>> mAllProducteurs;

    ProducteurRepository(Application application) {
        CommandRoomDatabase db = CommandRoomDatabase.getDatabase(application);
        mCommandDao = db.commandDao();
        mAllProducteurs = mCommandDao.getAlphabetizedProducteurs();
    }

    LiveData<List<ProducteurData>> getAllProducteurs() {
        return mAllProducteurs;
    }

    void insertProducteur(ProducteurData producteurData) {
        CommandRoomDatabase.databaseWriteExecutor.execute(() -> {
            mCommandDao.insertProducteur(producteurData);
        });
    }
}
