package com.planetpay.views.bvn_verification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.planetpay.R;
import com.planetpay.views.MainActivity;

public class BvnVerificationActivity extends AppCompatActivity {
    private Button verifyButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bvn_verification);
        verifyButton = findViewById(R.id.activity_bvn_verification_button);
        verifyButton.setOnClickListener(v -> startActivity(new Intent(this, MainActivity.class)));
    }
}
