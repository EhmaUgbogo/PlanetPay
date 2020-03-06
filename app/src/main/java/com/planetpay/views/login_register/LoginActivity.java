package com.planetpay.views.login_register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.planetpay.BaseActivity;
import com.planetpay.R;
import com.planetpay.views.bvn_verification.BvnVerificationActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends BaseActivity {

    private static final String TAG = "planetpay.LOGINACTIVITY";
    private EditText emailEditText, passwordEditText;
    private Button loginButton, signUpButton;
    private ProgressBar progressBar;
    private Dialog dialog;
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
        listeners();
    }

    private void listeners() {
        signUpButton.setOnClickListener(v -> startActivity(new Intent(this,RegisterActivity.class)));
        loginButton.setOnClickListener(v -> {
            if(checkNetworkState()) {
                loginUser(emailEditText.getText().toString(), passwordEditText.getText().toString());
            }
        });
    }

    private void loginUser(String email, String password){
        showProgress();
        if (validateInputs(email, password)){
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    Log.d(TAG, "User created successfully" + task.isSuccessful());
                    if (task.isSuccessful()){
                        checkEmailVerification();

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

    private void checkEmailVerification() {
        FirebaseUser currentUser = auth.getCurrentUser();
        if(currentUser.isEmailVerified()){
            hideProgress();
            Intent i = new Intent(this, BvnVerificationActivity.class);
            startActivity(i);
        }else{

            hideProgress();
            showAlert();
        }
    }

    private void showAlert() {
        final AlertDialog.Builder myDialog = new AlertDialog.Builder(this);
        View customView = getLayoutInflater().inflate(R.layout.dialog_not_verified_dialog, null);
        Button resendBtn = customView.findViewById(R.id.dialog_not_verified_resend_btn);
        resendBtn.setOnClickListener(v -> {
            sendVerificationEmail();
        });
        myDialog.setView(customView);
        dialog = myDialog.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    private void sendVerificationEmail() {
        auth.getCurrentUser().sendEmailVerification()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            hideProgress();
                            dialog.dismiss();
                            inflateAlert();
                        }
                        else{
                            firebaseUser.delete();
                            hideProgress();
                            showToast("Please Try Again. ");
                        }
                    }
                });
    }

    private void inflateAlert() {
        final AlertDialog.Builder myDialog = new AlertDialog.Builder(this);
        View customView = getLayoutInflater().inflate(R.layout.dialog_successful_reg_dialog, null);
        Button loginBtn = customView.findViewById(R.id.dialog_successful_login_btn);
        myDialog.setView(customView);
        dialog = myDialog.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        loginBtn.setOnClickListener(v -> {
            dialog.dismiss();
        });
        dialog.show();
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
