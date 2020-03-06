package com.planetpay.views.funds_transfer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.planetpay.R;

public class AccountNumberFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account_number, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button nextBtn = view.findViewById(R.id.button2);

        nextBtn.setOnClickListener(v -> {
            navigate();
        });
    }

    private void navigate() {
        NavController navController = Navigation.findNavController(getActivity(), R.id.funds_transfer_navHostFragment);
        navController.navigate(R.id.action_accountNumberFragment_to_verifyDetailsFragment);
    }
}
