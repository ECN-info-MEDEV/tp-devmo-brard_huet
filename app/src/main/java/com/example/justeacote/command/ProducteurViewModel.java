package com.example.justeacote.command;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ProducteurViewModel extends AndroidViewModel {
    private ProducteurRepository mRepository;
    private final LiveData<List<ProducteurData>> mAllProducteurs;
    public ProducteurViewModel(Application application) {
        super(application);
        mRepository = new ProducteurRepository(application);
        mAllProducteurs = mRepository.getAllProducteurs();
    }

    LiveData<List<ProducteurData>> getAllProducteurs() {return mAllProducteurs;}

    public void insert(ProducteurData producteur) { mRepository.insertProducteur(producteur); }
}
