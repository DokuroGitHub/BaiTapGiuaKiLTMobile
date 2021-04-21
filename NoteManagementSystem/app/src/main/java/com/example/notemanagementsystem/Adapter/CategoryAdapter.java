package com.example.notemanagementsystem.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notemanagementsystem.Model.Category;
import com.example.notemanagementsystem.R;
import com.example.notemanagementsystem.ui.category.Add_dialog;
import com.example.notemanagementsystem.ui.category.CategoryModel;
import com.example.notemanagementsystem.ui.category.Update_dialog;

import java.util.List;

/**
 * This class used to create RecyclerView.Adapter
 * Adapter is a place to progress data and assign data for RecyclerView
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder>  {
    //init
    private List<Category> mListCategory;
    private Context context;

    public void setData (List<Category> list){
        this.mListCategory = list;
        notifyDataSetChanged();
    }

    public CategoryAdapter(Context ct){
        context = ct;
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
        holder.txtCategoryName.setText("Name: "+category.getCategoryName());
        holder.txtCreateDate.setText("Create date: "+category.getCreateDate().toString());
    }

    @Override
    public int getItemCount() {
        if(mListCategory != null)
            return mListCategory.size();
        return 0;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        TextView txtCategoryName, txtCreateDate;
        LinearLayout category_layout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCategoryName = itemView.findViewById(R.id.txtCategoryName);
            txtCreateDate = itemView.findViewById(R.id.txtCreateDate);
            category_layout = itemView.findViewById(R.id.category_layout);
            //set edit and delete when click item in recyclerView with context menu
            category_layout.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(getAdapterPosition(),101,0,"Edit");
            menu.add(getAdapterPosition(),102,1,"Delete");
        }

    }

}


