package com.planetpay;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.planetpay.api.ApiConstantProvider;
import com.planetpay.api.response.bvn.ResetResponse;
import com.planetpay.views.MainActivity;

import org.jetbrains.annotations.NotNull;

import static com.planetpay.api.ApiConstantProvider.SANDBOX_KEY;
import static com.planetpay.api.ApiConstantProvider.orgCodeInBASE64;

public class SplashActivity extends BaseActivity {
    private static final String TAG = "SplashActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getBvnResetResponseData();

    }

    private void getBvnResetResponseData() {
        Call<ResetResponse> resetResponseCall = getDataManager().getPlanetPayApi().bvnValidationReset(orgCodeInBASE64,SANDBOX_KEY);
        resetResponseCall.enqueue(new Callback<ResetResponse>() {
            @Override
            public void onResponse(@NotNull Call<ResetResponse> call, @NotNull Response<ResetResponse> response) {
                if (response.isSuccessful()) {
                    ResetResponse resetResponse = response.body();
                    if(resetResponse==null) {
                        Log.d(TAG, "onResponse: successful resetResponse is null");
                        getBvnResetResponseData(); return;
                    }
                    getDataManager().setBvnResetResponse(resetResponse);
                    proceed();
                    Log.d(TAG, resetResponse.toString());
                } else {
                    Log.d(TAG, "Code: " + response.code() + "message; " + response.message());
                    getBvnResetResponseData();
                }
                hideProgressbar();
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
        startActivity(new Intent(this, MainActivity.class));
    }

    private void hideProgressbar() {
        //progressBar.setVisibility(View.GONE);
    }

    private void showProgressbar() {
        //progressBar.setVisibility(View.VISIBLE);
    }




}
