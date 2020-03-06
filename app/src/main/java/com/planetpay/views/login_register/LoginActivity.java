package com.planetpay.views.login_register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.planetpay.R;

public class LoginActivity extends AppCompatActivity {

    private EditText email_edit, password_edit;
    private Button login_btn, sign_up_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews() {

        email_edit = findViewById(R.id.activity_sign_in_email_editText);
        password_edit = findViewById(R.id.activity_sign_in_password_editText);

        login_btn = findViewById(R.id.activity_sign_in_button_sign_in);
        sign_up_btn = findViewById(R.id.activity_sign_in_button_sign_up);

    }
}
