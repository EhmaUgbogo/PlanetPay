package com.planetpay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.planetpay.datastore.DataManager;
import com.planetpay.utils.Common;

import androidx.appcompat.app.AppCompatActivity;

import static com.planetpay.utils.Constants.COLLECTION_USERS;

public class BaseActivity extends AppCompatActivity {
    private DataManager dataManager;
    protected FirebaseFirestore db;
    protected FirebaseAuth auth;
    protected FirebaseUser firebaseUser;
    protected CollectionReference userRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        dataManager = ((Common)this.getApplicationContext()).getDataManager();
        db = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build();
        db.setFirestoreSettings(settings);
        auth = FirebaseAuth.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        userRef = db.collection(COLLECTION_USERS);

    }

    protected void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void showSnackBar(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG)
                /*.setAction("Action", null)*/
                .show();
    }

    protected boolean checkNetworkState() {
        if (!Common.checkNetwork(this)) {
            showToast("You do not have a network connection");
            return false;
        }
        return true;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

}
