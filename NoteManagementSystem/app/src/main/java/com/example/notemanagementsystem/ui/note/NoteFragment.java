package com.example.notemanagementsystem.ui.note;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notemanagementsystem.Adapter.NoteAdapter;
import com.example.notemanagementsystem.Model.Category;
import com.example.notemanagementsystem.Model.Note;
import com.example.notemanagementsystem.Model.NoteAndMenu;
import com.example.notemanagementsystem.R;
import com.example.notemanagementsystem.ui.category.CategoryModel;
import com.example.notemanagementsystem.ui.category.EditCategory;
import com.example.notemanagementsystem.ui.status.Add_dialog_status;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class NoteFragment extends Fragment implements NoteAdapter.ClickListener{

    private NoteViewModel noteViewModel;
    private FloatingActionButton btnNewNote;
    private NoteAdapter noteAdapter;
    private RecyclerView rcv_note;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        noteViewModel =
                new ViewModelProvider(this).get(NoteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_note, container, false);
        noteAdapter = new NoteAdapter(this);
        rcv_note = root.findViewById(R.id.rcv_note);
        rcv_note.setLayoutManager(new LinearLayoutManager(root.getContext()));
        noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);
        noteViewModel.getListNote().observe(getActivity(), new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                if(notes.size()>0){
                    noteAdapter.setData(notes);
                    rcv_note.setAdapter(noteAdapter);
                }
            }
        });

        //add form
        btnNewNote = root.findViewById(R.id.btnNewNote);
        btnNewNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Add_dialog_note add = new Add_dialog_note();
                add.show(getActivity().getSupportFragmentManager(),"add");
            }
        });
        return root;
    }

    @Override
    public void ClickedItem(Note note) {
        EditNote edit = new EditNote(note);
        edit.show(getActivity().getSupportFragmentManager(),"edit");
    }
}