package com.example.justeacote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.justeacote.command.CommandData;
import com.example.justeacote.command.CommandViewModel;
import com.example.justeacote.command.ProducteurData;
import com.example.justeacote.command.ProducteurViewModel;

public class ReserveActivity extends AppCompatActivity {
    private TextView mFirstName;
    private TextView mLastName;
    private TextView mProducteurDescription;
    private TextView mCommandDescription;
    private TextView mCommandName;
    private ProducteurViewModel mProducteurViewModel;
    private CommandViewModel mCommandViewModel;
    private ImageView mProducteurAvatar;
    final static String TAG = ReserveActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);

        mFirstName = findViewById(R.id.firstName);
        mLastName = findViewById(R.id.lastName);
        mProducteurDescription = findViewById(R.id.descriptionProd);
        mCommandDescription = findViewById(R.id.descriptionCommand);
        mCommandName = findViewById(R.id.reserveCommandName);
        mProducteurAvatar = findViewById(R.id.producteurAvatar);

        Intent intent = getIntent();
        int commandId = intent.getIntExtra("commandId", -1);

        mCommandViewModel = new ViewModelProvider(this).get(CommandViewModel.class);
        mProducteurViewModel = new ViewModelProvider(this).get(ProducteurViewModel.class);

        mCommandViewModel.getCommandById(commandId).observe(this, commands -> {
            CommandData command = commands.get(0);
            mCommandName.setText(command.getCommandName());
            mCommandDescription.setText(command.getCommandDescription());
            int producteurId = command.getProducteur();
            mProducteurViewModel.getProducteurByID(producteurId).observe(this, producteurs -> {
                ProducteurData producteur = producteurs.get(0);
                mFirstName.setText(producteur.getPrenom());
                mLastName.setText(producteur.getNom());
                mProducteurDescription.setText(producteur.getDescription());
                mProducteurAvatar.setImageResource(getProducteurImageFromLabel(producteur.getProducteurImgId()));
            });
        });

    }

    public int getProducteurImageFromLabel(String pictureLabel) {
        int id = this.getResources().getIdentifier(pictureLabel, "drawable", this.getPackageName());
        if (id == 0) {
            id = R.drawable.farmer3;
        }
        return id;
    }
}