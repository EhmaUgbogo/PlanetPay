package com.planetpay.views.provide_bank_account_number;

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
import com.planetpay.models.Banks;
import com.planetpay.views.provide_bank_account_number.adapter.InputAccountNumberAdapter;
import com.planetpay.views.provide_bank_account_number.adapter.SelectBankAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectBankFragment extends Fragment {

    private RecyclerView recyclerView;
    private SelectBankAdapter selectBankAdapter;
    private Button nextBtn;

    private List<Banks> banks = new ArrayList<>();

    public SelectBankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select_bank, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.fragment_select_bank_rv);
        dummyData();
        selectBankAdapter = new SelectBankAdapter(getContext(),banks);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(selectBankAdapter);

        nextBtn = view.findViewById(R.id.fragment_select_bank_next_btn);

        nextBtn.setOnClickListener(v -> navigate());
    }

    private void navigate() {
        NavController navController = Navigation.findNavController(getActivity(), R.id.acct_num_navHostFragment);
        navController.navigate(R.id.action_selectBankFragment_to_inputAccountNumberFragment);
    }

    private void dummyData() {
        banks.add(new Banks("Sterling Bank", R.drawable.sterling ));
        banks.add(new Banks("GT Bank", R.drawable.gt_bank ));
        banks.add(new Banks("First Bank", R.drawable.first_bank ));
        banks.add(new Banks("UBA", R.drawable.uba ));
        banks.add(new Banks("Access Bank", R.drawable.access ));
    }
}
