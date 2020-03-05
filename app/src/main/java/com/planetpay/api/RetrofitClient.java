package com.planetpay.api;

import com.planetpay.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.planetpay.api.ApiConstantProvider.BASE_URL;

public class RetrofitClient {
    private static Retrofit INSTANCE;

    public static synchronized Retrofit getInstance() {
        if (INSTANCE == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.level(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(2, TimeUnit.MINUTES)
                    .readTimeout(2, TimeUnit.MINUTES)
                    .writeTimeout(2, TimeUnit.MINUTES)
                    .addInterceptor(interceptor)
                    .build();


            Retrofit.Builder builder = new Retrofit.Builder();
            builder.baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create());
            //.addCallAdapterFactory(RxJava3CallAdapterFactory.create());
            if(BuildConfig.DEBUG){
                builder.client(okHttpClient);
            }
            return builder.build();
        } else {
            return INSTANCE;
        }
    }
}
