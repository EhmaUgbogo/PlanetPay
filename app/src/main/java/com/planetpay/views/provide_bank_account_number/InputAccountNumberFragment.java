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
import com.planetpay.models.Bank;
import com.planetpay.views.MainActivity;
import com.planetpay.views.provide_bank_account_number.adapter.InputAccountNumberAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class InputAccountNumberFragment extends Fragment {
    private RecyclerView recyclerView;
    private InputAccountNumberAdapter inputAccountNumberAdapter;
    private Button confirm_btn;
    private List<Bank> banks = new ArrayList<>();

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
        dummyData();
        inputAccountNumberAdapter = new InputAccountNumberAdapter(getContext(),banks);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(inputAccountNumberAdapter);

        confirm_btn = view.findViewById(R.id.fragment_input_acct_num_button);

        confirm_btn.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), MainActivity.class));
            getActivity().finish();
        });



    }

    private void dummyData() {
        banks.add(new Bank("Sterling Bank", R.drawable.sterling ));
        banks.add(new Bank("GT Bank", R.drawable.gt_bank ));
        banks.add(new Bank("First Bank", R.drawable.first_bank ));
        banks.add(new Bank("UBA", R.drawable.uba ));
        banks.add(new Bank("Access Bank", R.drawable.access ));
    }

}
