package com.planetpay.views.splash_activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.ChasingDots;
import com.pixplicity.easyprefs.library.Prefs;
import com.planetpay.BaseActivity;
import com.planetpay.R;
import com.planetpay.api.response.bvn.ResetResponse;
import com.planetpay.views.login_register.LoginActivity;

import org.jetbrains.annotations.NotNull;

import androidx.core.content.ContextCompat;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.planetpay.api.ApiConstantProvider.SANDBOX_KEY;
import static com.planetpay.api.ApiConstantProvider.orgCodeInBASE64;

public class SplashActivity extends BaseActivity {

    private static final String TAG = "SplashActivity";
    private final String APP_OPEN_FIRST_TIME = "com.planetpay_APP_OPEN_FIRST_TIME";
    private boolean firstTime;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorAccent));
        }

        firstTime = Prefs.getBoolean(APP_OPEN_FIRST_TIME, true);

        progressBar = findViewById(R.id.splash_progress);
        Sprite chasingDots = new ChasingDots();
        progressBar.setIndeterminateDrawable(chasingDots);

        getBvnResetResponseData();

    }


    private void getBvnResetResponseData() {
        showProgressbar();
        Call<ResetResponse> resetResponseCall = getDataManager().getPlanetPayApi().bvnValidationReset(orgCodeInBASE64, SANDBOX_KEY);
        resetResponseCall.enqueue(new Callback<ResetResponse>() {
            @Override
            public void onResponse(@NotNull Call<ResetResponse> call, @NotNull Response<ResetResponse> response) {
                if (response.isSuccessful()) {
                    ResetResponse resetResponse = response.body();
                    if (resetResponse == null) {
                        Log.d(TAG, "onResponse: successful resetResponse is null");
                        getBvnResetResponseData();
                        return;
                    }
                    getDataManager().setBvnResetResponse(resetResponse);
                    proceed();
                    Log.d(TAG, resetResponse.toString());
                } else {
                    Log.d(TAG, "Code: " + response.code() + "message; " + response.message());
                    getBvnResetResponseData();
                }

            }

            @Override
            public void onFailure(Call<ResetResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                showToast(t.getMessage());
                hideProgressbar();
            }
        });
    }

    private void proceed() {
        gotoLogin();
    }

    private void hideProgressbar() {
        progressBar.setVisibility(View.GONE);
    }

    private void showProgressbar() {
        progressBar.setVisibility(View.VISIBLE);
    }


    private void navigateTo() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (firstTime) {
                    Prefs.putBoolean(APP_OPEN_FIRST_TIME, false);
                    Intent login = new Intent(SplashActivity.this.getApplicationContext(), LoginActivity.class);
                    SplashActivity.this.startActivity(login);
                    SplashActivity.this.finish();
                } else {
                    //Should goto MainActivity
                    gotoLogin();
                }
            }
        }, 3000);
    }

    private void gotoLogin() {
        startActivity(new Intent(SplashActivity.this.getApplicationContext(), LoginActivity.class));
        SplashActivity.this.finish();
    }

}
