package com.planetpay.utils;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.pixplicity.easyprefs.library.Prefs;
import com.planetpay.datastore.DataManager;


public class Common extends Application {
    private DataManager dataManager;

    @Override
    public void onCreate() {
        super.onCreate();

        initPrefLib();
        dataManager=new DataManager();

    }


    private void initPrefLib() {
        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();

    }

    public static boolean checkNetwork(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public DataManager getDataManager() {
        return dataManager;
    }
}
