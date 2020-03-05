package com.planetpay;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.planetpay.datastore.DataManager;
import com.planetpay.utils.Common;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

    private DataManager dataManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataManager = ((Common) getActivity().getApplicationContext()).getDataManager();
    }

    protected void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }

    private void showSnackBar(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG)
                /*.setAction("Action", null)*/
                .show();
    }

    protected boolean checkNetworkState() {
        if (!Common.checkNetwork(getActivity())) {
            showToast("You do not have a network connection");
            return false;
        }
        return true;
    }

    public DataManager getDataManager() {
        return dataManager;
    }
}
