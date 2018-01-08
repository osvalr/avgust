package pe.kapcom.coravi.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pe.kapcom.coravi.R;
import pe.kapcom.coravi.helper.AppCompatActivityHelper;
import pe.kapcom.coravi.taskasync.LoginTaskAsync;
import pe.kapcom.coravi.types.LoginRequestType;
import pe.kapcom.coravi.types.LoginResponseType;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivityHelper {

    // UI references.
    private EditText txtUsername;
    private EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        txtUsername = (EditText) findViewById(R.id.username);
        txtPassword = (EditText) findViewById(R.id.password);

        Button btnLogIN = (Button) findViewById(R.id.login_sign_in_button);
        btnLogIN.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

    }

    public void login(){

        txtUsername.setError(null);
        txtPassword.setError(null);

        // Store values at the time of the login attempt.
        String username = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();

        LoginRequestType loginRequestType = new LoginRequestType();
        loginRequestType.setNombre_usuario(username);
        loginRequestType.setClave_usuario(password);

        LoginTaskAsync loginWSAsyncTask = new LoginTaskAsync();
        loginWSAsyncTask.setLoginActivity(this);
        loginWSAsyncTask.execute(loginRequestType);
    }

    public void resultLogin(LoginResponseType loginResponseType){

        if(!loginResponseType.isStatusLogin()){
            showMessage(loginResponseType.getMessage());
        }else{

            Intent siguiente = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(siguiente);
        }

    }
}

