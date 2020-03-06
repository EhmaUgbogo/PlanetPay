package com.planetpay.views.funds_transfer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.planetpay.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VerifyDetailsFragment extends Fragment {

    public VerifyDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_verify_details, container, false);
    }
}
