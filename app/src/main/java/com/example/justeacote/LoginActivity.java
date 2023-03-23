package com.example.justeacote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.justeacote.command.CommandActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        int a = R.id.editTextUsername_login;

        username = findViewById(R.id.editTextUsername_login);
        password = findViewById(R.id.editTextPassword_login);

        login = findViewById(R.id.buttonLogin_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifConnexion();
            }
        });
        register = findViewById(R.id.buttonRegister_login);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerAction();
            }
        });
    }

    public void verifConnexion(){
        Intent intent = new Intent(this, CommandActivity.class);
        startActivity(intent);
    }

    public void registerAction(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

}