package com.planetpay.utils;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.pixplicity.easyprefs.library.Prefs;
import com.planetpay.models.User;

public class App extends Application {
    public static final String NOTIFICATION_CHANNEL_ID = "com.ehmaugbogo.rigotrack_NOTIFICATION_CHANNEL_ID";
    private static User appUser;

    @Override
    public void onCreate() {
        super.onCreate();
        initPrefLib();
        createNotificationChannel();

    }

    private void createNotificationChannel() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "Weatherupfront Channel 1", NotificationManager.IMPORTANCE_HIGH);
            channel.shouldVibrate();
            channel.setDescription("Notify users on important updates with vibration and sound");

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

        }
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

    public static User getAppUser() {
        return appUser;
    }

    public static void setAppUser(User appUser) {
        App.appUser = appUser;
    }
}
