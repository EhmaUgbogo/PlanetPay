package com.planetpay.views.provide_bank_account_number.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.planetpay.R;
import com.planetpay.models.Banks;
import com.planetpay.models.SelectedBanks;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class SelectBankAdapter extends RecyclerView.Adapter<SelectBankAdapter.ViewHolder> {
    private Context context;
    private List<Banks> banks;
    public List<SelectedBanks> selectedBanks = new ArrayList<>();
    public SelectBankAdapter(Context context, List<Banks> banks){
        this.context = context;
        this.banks = banks;
    }


    @NonNull
    @Override
    public SelectBankAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bank_select_item, parent, false);
        return new SelectBankAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectBankAdapter.ViewHolder holder, int position) {
        Banks item = banks.get(position);
        holder.bank_logo.setImageResource(item.getImageUrl());
        holder.bank_name.setText(item.getName());
        holder.itemView.setOnClickListener(v -> {
            if(holder.checkBox.isChecked()){
                holder.checkBox.setVisibility(View.INVISIBLE);
                holder.checkBox.setChecked(false);
            }else{
                holder.checkBox.setChecked(true);
                holder.checkBox.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return banks.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView bank_logo;
        private TextView bank_name;
        private CheckBox checkBox;
        public ViewHolder(View view) {
            super(view);
            bank_logo = view.findViewById(R.id.item_bank_select_bank_image_view);
            bank_name = view.findViewById(R.id.item_bank_select_bank_name_text_view);
            checkBox = view.findViewById(R.id.item_bank_select_checkbox);
        }
    }

}
