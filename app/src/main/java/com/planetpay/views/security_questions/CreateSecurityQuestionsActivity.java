package com.planetpay.views.security_questions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.planetpay.R;
import com.planetpay.views.provide_bank_account_number.ProvideBankAccountNumberActivity;

public class CreateSecurityQuestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_security_questions);

        Button button = findViewById(R.id.submit_questions_btn);
        button.setOnClickListener(v ->{
            startActivity(new Intent(this, ProvideBankAccountNumberActivity.class));
        });
    }
}
