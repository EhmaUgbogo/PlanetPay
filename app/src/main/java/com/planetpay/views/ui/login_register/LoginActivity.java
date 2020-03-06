package com.planetpay.views.ui.login_register;

import androidx.annotation.NonNull;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.planetpay.BaseActivity;
import com.planetpay.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends BaseActivity {

    private static final String TAG = "planetpay.LOGINACTIVITY";
    private EditText emailEditText, passwordEditText;
    private Button loginButton, signUpButton;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews() {

        emailEditText = findViewById(R.id.activity_sign_in_email_editText);
        passwordEditText = findViewById(R.id.activity_sign_in_password_editText);

        loginButton = findViewById(R.id.activity_sign_in_button_sign_in);
        signUpButton = findViewById(R.id.activity_sign_in_button_sign_up);
        progressBar = findViewById(R.id.activity_sign_in_progressBar);

    }
    private void loginUser(String email, String password){
        showProgress();
        if (validateInputs(email, password)){
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){

                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    Log.d(TAG, "User created successfully" + task.isSuccessful());
                    if (task.isSuccessful()){


                    }else {
                        hideProgress();
                    }

                }
            });
        }else {
            showToast("Check required inputs");
            hideProgress();
        }
    }

    private boolean validateInputs(String email, String password) {
        boolean status=true;

        if(!isValidEmail(email)){
            emailEditText.setError("A valid Email Required");
            status =false;
        }

        if(!isValidPassword(password)){
            passwordEditText.setError("Password of 8 characters & above Required");
            status= false;
        }

        return status;
    }



    // validating email id
    public boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    // validating password with retype password
    public boolean isValidPassword(String pass) {
        return pass != null && pass.length() >= 8;
    }

    public void showProgress(){
        progressBar.setVisibility(View.VISIBLE);
        loginButton.setEnabled(false);
        signUpButton.setEnabled(false);
    }

    public void hideProgress(){
        progressBar.setVisibility(View.INVISIBLE);
        loginButton.setEnabled(true);
        signUpButton.setEnabled(true);

    }

}
