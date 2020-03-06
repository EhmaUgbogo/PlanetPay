package com.planetpay.views.provide_bank_account_number.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.planetpay.R;
import com.planetpay.models.Bank;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class InputAccountNumberAdapter extends RecyclerView.Adapter<InputAccountNumberAdapter.ViewHolder> {
    private Context context;
    private List<Bank> banks;

    public InputAccountNumberAdapter(Context context, List<Bank> banks){
        this.context = context;
        this.banks = banks;
    }
    @NonNull
    @Override
    public InputAccountNumberAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_add_account_number_item, parent, false);

        return new InputAccountNumberAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Bank item = banks.get(position);
        holder.bank_logo.setImageResource(item.getImageUrl());
        holder.bank_name.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView bank_logo;
        private TextView bank_name;

        public ViewHolder(View view) {
            super(view);
            bank_logo = view.findViewById(R.id.item_add_account_number_bank_image_view);
            bank_name = view.findViewById(R.id.item_add_account_number_bank_text_view);

        }
    }
}
