package com.samyotech.laundrydriver.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.samyotech.laundrydriver.R;
import com.samyotech.laundrydriver.databinding.AdapterAllservicesBinding;
import com.samyotech.laundrydriver.interfaces.Consts;
import com.samyotech.laundrydriver.model.ServicesDTO;

import java.util.ArrayList;

public class AllServicesAdapter extends RecyclerView.Adapter<AllServicesAdapter.MyViewHolder> {

    LayoutInflater layoutInflater;
    AdapterAllservicesBinding binding;
    Context kContext;
    ArrayList<ServicesDTO> popLaundryDTOArrayList;

    public AllServicesAdapter(Context kContext, ArrayList<ServicesDTO> popLaundryDTOArrayList) {
        this.kContext = kContext;
        this.popLaundryDTOArrayList = popLaundryDTOArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.adapter_allservices, parent, false);
        return new MyViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        Glide.with(kContext)
                .load(Consts.BASE_URL + popLaundryDTOArrayList.get(position).getImage())
                .placeholder(R.drawable.laundryshop)
                .into(holder.binding.image);

        holder.binding.namaJasa.setText(popLaundryDTOArrayList.get(position).getService_name());


    }

    @Override
    public int getItemCount() {
        return popLaundryDTOArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterAllservicesBinding binding;

        public MyViewHolder(@NonNull AdapterAllservicesBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
