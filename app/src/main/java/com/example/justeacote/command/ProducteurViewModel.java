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

    public LiveData<List<ProducteurData>> getAllProducteurs() {return mAllProducteurs;}
    public LiveData<List<ProducteurData>> getProducteurByID(int id) {return mRepository.getProducteurById(id);}

    public void insert(ProducteurData producteur) { mRepository.insertProducteur(producteur); }
}
