package com.example.justeacote.command;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

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

    @Override
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ProducteurData other = (ProducteurData) obj;
        if (!Objects.equals(this.id, other.getId())) {
            return false;
        }
        if (!Objects.equals(this.description, other.getDescription())) {
            return false;
        }
        if (!Objects.equals(this.nom, other.getNom())) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.getPrenom())) {
            return false;
        }
        return true;
    }
}
