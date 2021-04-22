package com.example.notemanagementsystem.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notemanagementsystem.Model.Status;
import com.example.notemanagementsystem.R;

import java.util.List;

/**
 * This class used to create RecyclerView.Adapter
 * Adapter is a place to progress data and assign data for RecyclerView
 */

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.MyViewHolder>  {
    //init
    private List<Status> mListStatus;

    public void setData (List<Status> list){
        this.mListStatus = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.status_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Status status = mListStatus.get(position);
        if (status == null){
            return;
        }
        holder.txtStatusName.setText("Name: " + status.getStatusName());
        holder.txtCreateDate.setText("Created Date: " + status.getCreateDate());
    }

    @Override
    public int getItemCount() {
        if(mListStatus!= null)
            return mListStatus.size();
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtStatusName, txtCreateDate;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtStatusName = itemView.findViewById(R.id.txtStatusName);
            txtCreateDate = itemView.findViewById(R.id.txtCreateDate);
        }
    }
}
