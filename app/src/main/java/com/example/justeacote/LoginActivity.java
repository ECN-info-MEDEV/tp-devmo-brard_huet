package com.example.justeacote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.justeacote.command.CommandActivity;
import com.example.justeacote.login.User;
import com.example.justeacote.login.UserViewModel;

/**
 * Activité principale de l'application elle gère la connexion de l'utilisateur
 */
public class LoginActivity extends AppCompatActivity {

    public static final int NEW_USER_ACTIVITY_REQUEST_CODE = 1;

    private EditText username;
    private EditText password;
    private UserViewModel userViewModel;

    /**
     * La création de cette l'activité entraine la création de l'UI associé
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        username = findViewById(R.id.editTextUsername_login);
        password = findViewById(R.id.editTextPassword_login);

        Button login = findViewById(R.id.buttonLogin_login);
        login.setOnClickListener(v -> verifConnexion());
        Button register = findViewById(R.id.buttonRegister_login);
        register.setOnClickListener(v -> registerAction());
    }

    /**
     * Fonction servant à vérifier la connexion après que l'utilisateur ait rentré ses informations
     */
    public void verifConnexion(){
        if (!(TextUtils.isEmpty(username.getText()) || TextUtils.isEmpty(password.getText()))) {
            String name = username.getText().toString();
            String pass = password.getText().toString();
            new Thread(() -> {
                User answer = userViewModel.getConnexionInfo(name,pass);
                if (answer != null) {
                    Intent intent = new Intent(getApplicationContext(), CommandActivity.class);
                    startActivity(intent);
                }
                else{
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "Connexion impossible!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }).start();
        }
    }

    /**
     * Fonction servant à lancer une création de compte utilisateur
     */
    public void registerAction(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivityForResult(intent, NEW_USER_ACTIVITY_REQUEST_CODE);
    }

    /**
     * Cette fonction gère le retour de l'appel à la création de compte
     *
     * @param requestCode The integer request code originally supplied to
     *                    startActivityForResult(), allowing you to identify who this
     *                    result came from.
     * @param resultCode The integer result code returned by the child activity
     *                   through its setResult().
     * @param data An Intent, which can return result data to the caller
     *               (various data can be attached to Intent "extras").
     */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_USER_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            String[] answer = data.getStringExtra(RegisterActivity.EXTRA_REPLY).split(";");
            String name = answer[0];
            String pass = answer[1];
            User user = new User(name,pass);
            userViewModel.insert(user);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "Utilisateur non créé",
                    Toast.LENGTH_LONG).show();
        }
    }

}