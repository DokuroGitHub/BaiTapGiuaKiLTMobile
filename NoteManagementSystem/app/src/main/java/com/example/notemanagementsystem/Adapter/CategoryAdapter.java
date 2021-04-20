package com.example.notemanagementsystem.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notemanagementsystem.Model.Category;
import com.example.notemanagementsystem.R;

import java.util.List;

/**
 * This class used to create RecyclerView.Adapter
 * Adapter is a place to progress data and assign data for RecyclerView
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder>  {
    //init
    private List<Category> mListCategory;

    public void setData (List<Category> list){
        this.mListCategory = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Category category = mListCategory.get(position);
        if (category == null){
            return;
        }
        holder.txtCategoryName.setText(category.getCategoryName());
        holder.txtCreateDate.setText(category.getCreateDate().toString());
    }

    @Override
    public int getItemCount() {
        if(mListCategory != null)
            return mListCategory.size();
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtCategoryName, txtCreateDate;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCategoryName = itemView.findViewById(R.id.txtCategoryName);
            txtCreateDate = itemView.findViewById(R.id.txtCreateDate);
        }
    }
}
