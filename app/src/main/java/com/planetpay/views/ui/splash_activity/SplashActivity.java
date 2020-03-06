package com.planetpay.views.ui.splash_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import com.pixplicity.easyprefs.library.Prefs;
import com.planetpay.BaseActivity;
import com.planetpay.R;
import com.planetpay.views.MainActivity;
import com.planetpay.views.ui.login_register.LoginActivity;
import com.planetpay.views.ui.login_register.RegisterActivity;

public class SplashActivity extends BaseActivity {

    private static final String TAG = "SplashActivity";
    private final String APP_OPEN_FIRST_TIME = "com.planetpay_APP_OPEN_FIRST_TIME";
    private boolean firstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorAccent));
        }

        firstTime = Prefs.getBoolean(APP_OPEN_FIRST_TIME, true);

        navigateTo();
    }

    private void navigateTo() {
        new Handler().postDelayed(() -> {
            if (firstTime) {
                Prefs.putBoolean(APP_OPEN_FIRST_TIME, false);
                Intent login = new Intent(SplashActivity.this.getApplicationContext(), LoginActivity.class);
                SplashActivity.this.startActivity(login);
                SplashActivity.this.finish();
            } else {
                //Should goto MainActivity
                SplashActivity.this.startActivity(new Intent(SplashActivity.this.getApplicationContext(), LoginActivity.class));
                SplashActivity.this.finish();
            }
        },3000);
    }
}
