package com.example.notemanagementsystem.Adapter;

import android.content.Context;
<<<<<<< HEAD
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
=======
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
>>>>>>> Category
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.PrimaryKey;

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
    private Context context;
    private List<Category> mListCategory;
<<<<<<< HEAD
    private Context context;
=======
    private ClickListener clickListener;


    public CategoryAdapter(ClickListener clickListener){
        this.clickListener = clickListener;
    }
>>>>>>> Category

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
        context = parent.getContext();
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Category category = mListCategory.get(position);
        if (category == null){
            return;
        }
<<<<<<< HEAD
        holder.txtCategoryName.setText("Name: "+category.getCategoryName());
        holder.txtCreateDate.setText("Create date: "+category.getCreateDate().toString());
=======
        holder.txtCategoryName.setText("Name: " + category.getCategoryName());
        holder.txtCreateDate.setText("Create date: "+category.getCreateDate().toString());
        holder.category_item.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showPopup(v,category);
                return false;
            }
        });

    }


    public void showPopup(View view, Category category){
        PopupMenu popupMenu = new PopupMenu(context,view);
        popupMenu.inflate(R.menu.menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.menu_edit:
                        clickListener.updateClicked(category);
                        break;
                    case R.id.menu_delete:
                        clickListener.deleteClicked(category);
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
>>>>>>> Category
    }

    @Override
    public int getItemCount() {
        if(mListCategory != null)
            return mListCategory.size();
        return 0;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        TextView txtCategoryName, txtCreateDate;
<<<<<<< HEAD
        LinearLayout category_layout;
=======
        LinearLayout category_item;
>>>>>>> Category
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCategoryName = itemView.findViewById(R.id.txtCategoryName);
            txtCreateDate = itemView.findViewById(R.id.txtCreateDate);
<<<<<<< HEAD
            category_layout = itemView.findViewById(R.id.category_layout);
            //set edit and delete when click item in recyclerView with context menu
            category_layout.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(getAdapterPosition(),101,0,"Edit");
            menu.add(getAdapterPosition(),102,1,"Delete");
=======
            category_item =itemView.findViewById(R.id.category_item);
>>>>>>> Category
        }

    }

<<<<<<< HEAD
=======
    public interface ClickListener{
        void updateClicked(Category category);
        void deleteClicked(Category category);
    }

>>>>>>> Category
}


