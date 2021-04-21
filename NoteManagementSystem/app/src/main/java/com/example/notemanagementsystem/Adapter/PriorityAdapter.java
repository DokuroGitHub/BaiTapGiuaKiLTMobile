package com.example.notemanagementsystem.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notemanagementsystem.Model.Priority;
import com.example.notemanagementsystem.R;

import java.util.List;

/**
 * This class used to create RecyclerView.Adapter
 * Adapter is a place to progress data and assign data for RecyclerView
 */
public class PriorityAdapter extends RecyclerView.Adapter<PriorityAdapter.MyViewHolder> {
    //init
    private List<Priority> mListPriority;

    public void setData(List<Priority> list){
        this.mListPriority = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.priority_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Priority priority = mListPriority.get(position);
        if(priority == null) {
            return;
        }
        holder.txtPriorityName.setText(priority.getPriorityName());
        holder.txtCreate_Priority_Date.setText(priority.getCreate_priority_Date().toString());

    }

    @Override
    public int getItemCount() {
        if(mListPriority != null)
            return mListPriority.size();
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtPriorityName, txtCreate_Priority_Date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPriorityName = itemView.findViewById(R.id.txtPriorityName);
            txtCreate_Priority_Date = itemView.findViewById(R.id.txtCreate_Priority_Date);
        }
    }
}
