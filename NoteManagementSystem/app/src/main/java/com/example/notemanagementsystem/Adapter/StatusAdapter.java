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

import com.example.notemanagementsystem.Model.Status;
import com.example.notemanagementsystem.R;

import java.util.List;

/**
 * This class used to create RecyclerView.Adapter
 * Adapter is a place to progress data and assign data for RecyclerView
 */
public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.MyViewHolder>  {
    //init
    private Context context;
    private List<Status> mListStatus;
    private ClickListener clickListener;


    public StatusAdapter(ClickListener clickListener){
        this.clickListener = clickListener;
    }


    public void setData (List<Status> list){
        this.mListStatus = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
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
        holder.txtCreateDate.setText("Create date: "+status.getCreateDate().toString());
        holder.status_item.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showPopup(v,status);
                return false;
            }
        });

    }


    public void showPopup(View view, Status status){
        PopupMenu popupMenu = new PopupMenu(context,view);
        popupMenu.inflate(R.menu.menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.menu_edit:
                        clickListener.updateClicked(status);
                        break;
                    case R.id.menu_delete:
                        clickListener.deleteClicked(status);
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    @Override
    public int getItemCount() {
        if(mListStatus != null)
            return mListStatus.size();
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtStatusName, txtCreateDate;
        LinearLayout status_item;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtStatusName = itemView.findViewById(R.id.txtStatusName);
            txtCreateDate = itemView.findViewById(R.id.txtCreateDate);
            status_item =itemView.findViewById(R.id.status_item);
        }
    }

    public interface ClickListener{
        void updateClicked(Status status);
        void deleteClicked(Status status);
    }
//
}