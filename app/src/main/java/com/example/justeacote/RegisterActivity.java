package com.example.justeacote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.newusersql.REPLY";
    private EditText username;
    private EditText password;
    private EditText confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.editTextUsername_register);
        password = findViewById(R.id.editTextPassword_register);
        confirmPassword = findViewById(R.id.editTextConfirmPassword_register);

        Button register = findViewById(R.id.buttonRegister_register);
        register.setOnClickListener(v -> registerAction());
    }

    private void registerAction() {
        Intent replyIntent = new Intent();
        if (TextUtils.isEmpty(username.getText()) || TextUtils.isEmpty(password.getText()) || TextUtils.isEmpty(confirmPassword.getText())) {
            setResult(RESULT_CANCELED, replyIntent);
        } else {
            String name = username.getText().toString();
            String pass = password.getText().toString();
            String confirmpass = confirmPassword.getText().toString();
            if (pass.equals(confirmpass)) {
                String answer = name + ";" + pass;
                replyIntent.putExtra(EXTRA_REPLY, answer);
                setResult(RESULT_OK, replyIntent);
            }
            else{
                Toast.makeText(this, "Erreur, Confirmation du mot de passe différente de l'original", Toast.LENGTH_SHORT).show();
                setResult(RESULT_CANCELED, replyIntent);
            }
        }
        finish();
    }
}