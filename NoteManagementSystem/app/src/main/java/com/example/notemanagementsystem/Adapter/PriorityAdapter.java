package com.example.notemanagementsystem.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
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
    private Context context;
    private List<Priority> mListPriority;
    private ClickListener clickListener;

    public PriorityAdapter(ClickListener clickListener){
        this.clickListener = clickListener;
    }

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
        holder.txtPriorityName.setText("Name: " + priority.getPriorityName());
        holder.txtCreate_Priority_Date.setText("Create Date: " + priority.getCreate_priority_Date().toString());
        holder.priority_item.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showPopup(v, priority);
                return false;
            }
        });

    }

    public void showPopup(View view, Priority priority){
        PopupMenu popupMenu = new PopupMenu(context,view);
        popupMenu.inflate(R.menu.menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.menu_edit:
                        clickListener.updateClicked(priority);
                        break;
                    case R.id.menu_delete:
                        clickListener.deleteClicked(priority);
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    @Override
    public int getItemCount() {
        if(mListPriority != null)
            return mListPriority.size();
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtPriorityName, txtCreate_Priority_Date;
        LinearLayout priority_item;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPriorityName = itemView.findViewById(R.id.txtPriorityName);
            txtCreate_Priority_Date = itemView.findViewById(R.id.txtCreate_Priority_Date);
            priority_item =itemView.findViewById(R.id.priority_item);
        }
    }

    public interface ClickListener{
        void updateClicked(Priority priority);
        void deleteClicked(Priority priority);
    }
}
