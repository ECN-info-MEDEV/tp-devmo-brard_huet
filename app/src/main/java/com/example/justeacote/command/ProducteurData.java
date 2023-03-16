package com.example.justeacote.command;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "producteur")
public class ProducteurData {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    private String nom;
    @NonNull
    private String prenom;
    @NonNull
    private String description;

    public ProducteurData(int id, @NonNull String nom, @NonNull String prenom, @NonNull String description) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getNom() {
        return nom;
    }

    public void setNom(@NonNull String nom) {
        this.nom = nom;
    }

    @NonNull
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(@NonNull String prenom) {
        this.prenom = prenom;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }
}
