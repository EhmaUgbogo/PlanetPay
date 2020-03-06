package com.planetpay.views.ui.login_register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.planetpay.BaseActivity;
import com.planetpay.R;
import com.planetpay.models.User;
import com.planetpay.utils.App;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends BaseActivity {
    private static final String TAG = "planetpay.REGISTRATION";
    private EditText mFirstNameEditText, mMiddleNameEditText, mLastNameEditText, mBVNEditText, mDOBEditText, mPasswordEditText, mEmailEditText, mPhoneEditText, mConfirmPasswordEditText;
    private Button mRegisterUserButton;
    private String mFirstName, mMiddleName, mLastName, mBVN, mDOB, mPassword, mEmail, mPhone, mConfirmPassword;
    private ProgressBar progressBar;
    private final Calendar myCalendar = Calendar.getInstance();
    private DatePickerDialog.OnDateSetListener date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initCalendar();
        initView();
    }

    private void initView() {
        mFirstNameEditText = findViewById(R.id.activity_sign_up_first_name_editText);
        mMiddleNameEditText = findViewById(R.id.activity_sign_up_middle_name_editText);
        mBVNEditText = findViewById(R.id.activity_sign_up_bvn_editText);
        mDOBEditText = findViewById(R.id.activity_sign_up_dob_editText);
        mLastNameEditText = findViewById(R.id.activity_sign_up_last_name_editText);
        mEmailEditText = findViewById(R.id.activity_sign_up_email_editText);
        mPasswordEditText = findViewById(R.id.activity_sign_up_password_editText);
        mPhoneEditText = findViewById(R.id.activity_sign_up_phone_editText);
        mConfirmPasswordEditText = findViewById(R.id.activity_sign_up_confirm_password_editText);
        mRegisterUserButton = findViewById(R.id.activity_sign_up_button);
        progressBar = findViewById(R.id.activity_register_progressBar);
        listeners();
    }

    private void listeners() {
        mDOBEditText.setOnClickListener(v -> getDate());
        mRegisterUserButton.setOnClickListener(view -> {
            Log.d(TAG, "onClick: attempting to register user");

            mFirstName = mFirstNameEditText.getText().toString().trim();
            mMiddleName = mMiddleNameEditText.getText().toString().trim();
            mLastName = mLastNameEditText.getText().toString().trim();
            mPassword = mPasswordEditText.getText().toString().trim();
            mBVN = mBVNEditText.getText().toString().trim();
            mDOB = mDOBEditText.getText().toString().trim();
            mEmail = mEmailEditText.getText().toString().trim();
            mPhone = mPhoneEditText.getText().toString().trim();
            mConfirmPassword = mConfirmPasswordEditText.getText().toString().trim();

            if(checkNetworkState()){
                registerUser();
            }
        });
    }

    private void getDate() {
        new DatePickerDialog(RegisterActivity.this, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void registerUser() {
        showProgress();
        if (validateInputs()) {
            auth.createUserWithEmailAndPassword(mEmail, mPassword).addOnCompleteListener(this, task -> {
                Log.d(TAG, "Registration successful" + task.isSuccessful());
                if (task.isSuccessful()) {
                    sendVerificationEmail();
                } else {
                    Toast.makeText(getApplicationContext(), "Unable to Register User "+task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    hideProgress();
                }

            });
        } else {
            hideProgress();
        }
    }

    private void sendVerificationEmail() {
        auth.getCurrentUser().sendEmailVerification()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            User user = new User(mFirstName,mMiddleName,mLastName,mDOB,mBVN,mEmail,mPhone);
                            saveUserToFireStore(user, firebaseUser);
                            hideProgress();
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

    private void saveUserToFireStore(User user, FirebaseUser currentUser) {
        user.setUid(currentUser.getUid());

        showToast(user.getBvn());
        App.setAppUser(user);

        userRef.document(currentUser.getUid()).set(user)
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        Log.w(TAG, "saveUserToFireStore: New User Saved to database");
                    } else {
                        Log.w(TAG, "saveUserToFireStore Error: "+task.getException().getMessage());
                        Log.w(TAG, "saveUserToFireStore Restarting saving user");
                        saveUserToFireStore(user,currentUser);
                    }
                });
    }


    private boolean validateInputs() {
        mFirstNameEditText.setFilters(new InputFilter[]{new ValidateFilter()});
        mMiddleNameEditText.setFilters(new InputFilter[]{new ValidateFilter()});
        mLastNameEditText.setFilters(new InputFilter[]{new ValidateFilter()});

        if (!isValidEmail(mEmail)) {
            mEmailEditText.setError("Email Required");
            return false;
        }

        if (!isValidPhoneNo(mPhone)) {
            mPhoneEditText.setError("valid phone number Required");
            return false;
        }
        if (!isValidBVN(mBVN)) {
            mBVNEditText.setError("valid BVN Required");
            return false;
        }
        if (!isValidDOB(mDOB)) {
            mDOBEditText.setError("valid Date of Birth Required");
            return false;
        }

        if (!isValidPassword(mPassword)) {
            mPasswordEditText.setError("Password of 8 characters & above Required");
            return false;
        }

        if (!isValidConfirmPassword()) {
            mConfirmPasswordEditText.setError("Confirm Password not match");
            return false;
        }

        return true;
    }

    public static boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean isValidPhoneNo(String phoneNo) {
        return phoneNo != null && phoneNo.length() >= 10;
    }

    public boolean isValidBVN(String bvn) {
        return bvn != null && bvn.length() >= 10;
    }

    public boolean isValidDOB(String dob) {
        return dob != null ;
    }

    public boolean isValidPassword(String pass) {
        return pass != null && pass.length() >= 8;
    }

    public boolean isValidConfirmPassword() {
        return mPassword.equals(mConfirmPassword);
    }

    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        mRegisterUserButton.setEnabled(false);
    }

    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        mRegisterUserButton.setEnabled(true);
    }

    public void dateConverter(){
        String myFormat = "dd/MM/YYY";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        mDOBEditText.setText(sdf.format(myCalendar.getTime()));
    }
    public void initCalendar(){
         date = (view, year, monthOfYear, dayOfMonth) -> {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            dateConverter();
        };
    }

    public void inflateAlert() {
        final AlertDialog.Builder myDialog = new AlertDialog.Builder(this);
        View customView = getLayoutInflater().inflate(R.layout.dialog_successful_reg_dialog, null);
        Button loginBtn = customView.findViewById(R.id.dialog_successful_login_btn);
        loginBtn.setOnClickListener(v -> {
            startActivity(new Intent(this,LoginActivity.class));
            finish();
        });
        myDialog.setView(customView);
        Dialog dialog = myDialog.create();
        dialog.show();

    }



}
