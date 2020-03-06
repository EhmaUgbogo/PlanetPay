package com.planetpay.views.provide_bank_account_number;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.planetpay.R;
import com.planetpay.views.MainActivity;
import com.planetpay.views.provide_bank_account_number.adapter.InputAccountNumberAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class InputAccountNumberFragment extends Fragment {
    private RecyclerView recyclerView;
    private InputAccountNumberAdapter inputAccountNumberAdapter;
    private Button confirm_btn;


    public InputAccountNumberFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_account_number, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.fragment_input_acct_num_rv);
        inputAccountNumberAdapter = new InputAccountNumberAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(inputAccountNumberAdapter);

        confirm_btn = view.findViewById(R.id.fragment_input_acct_num_button);

        confirm_btn.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), MainActivity.class));
            getActivity().finish();
        });


    }

}
