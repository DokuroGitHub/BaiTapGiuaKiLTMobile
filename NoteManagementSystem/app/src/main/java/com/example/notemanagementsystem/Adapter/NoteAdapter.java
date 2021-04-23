package com.example.notemanagementsystem.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notemanagementsystem.Model.Category;
import com.example.notemanagementsystem.Model.Note;
import com.example.notemanagementsystem.Model.NoteAndMenu;
import com.example.notemanagementsystem.R;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyViewHolder> {
    private Context context;
    private List<NoteAndMenu> mListNote;
    private List<Note> mListNoteItem;
    private ClickListener clickListener;

    public NoteAdapter(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setData (List<NoteAndMenu> list){
        this.mListNote = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        NoteAndMenu note = mListNote.get(position);
        Note noteItem = mListNoteItem.get(position);
        if (note == null){
            return;
        }
        holder.txtNoteName.setText("Name: " + note.getNoteName());
        holder.txtCategoryName.setText("Category: "+note.getCategoryName());
        holder.txtPriorityName.setText("Priority: "+note.getPriorityName());
        holder.txtStatusName.setText("Status: "+note.getStatusName());
        holder.txtPlanDate.setText("Plan date: " + note.getPlantDate());
        holder.txtCreateDate.setText("Create date: "+note.getCurrentDate().toString());
        holder.item.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                clickListener.ClickedItem(noteItem);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        if(mListNote != null)
            return mListNote.size();
        if(mListNoteItem != null)
            return mListNote.size();
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtNoteName,txtCategoryName,txtPriorityName,txtStatusName;
        TextView txtPlanDate,txtCreateDate;
        LinearLayout item;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            txtNoteName = itemView.findViewById(R.id.txtNoteName);
            txtCategoryName = itemView.findViewById(R.id.txtCategoryName);
            txtPriorityName= itemView.findViewById(R.id.txtPriorityName);
            txtStatusName = itemView.findViewById(R.id.txtStatusName);
            txtPlanDate = itemView.findViewById(R.id.txtPlanDate);
            txtCreateDate = itemView.findViewById(R.id.txtCreateDate);
            item = itemView.findViewById(R.id.note_item);
        }
    }

    public interface ClickListener{
        void ClickedItem(Note note);
    }
}
