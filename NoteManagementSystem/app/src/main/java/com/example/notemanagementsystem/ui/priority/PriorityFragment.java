package com.example.notemanagementsystem.ui.priority;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notemanagementsystem.Adapter.PriorityAdapter;
import com.example.notemanagementsystem.Model.Priority;
import com.example.notemanagementsystem.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class PriorityFragment extends Fragment implements PriorityAdapter.ClickListener {

    private PriorityModel priorityModel;
    private RecyclerView rcv_Priority;
    private PriorityAdapter priorityAdapter;
    private List<Priority> mListPriority;
    private FloatingActionButton btnNewPriority;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_priority, container, false);
        priorityAdapter = new PriorityAdapter(this);
        rcv_Priority = root.findViewById(R.id.rcv_priority);
        rcv_Priority.setLayoutManager(new LinearLayoutManager(root.getContext()));
        priorityModel = new ViewModelProvider(this).get(PriorityModel.class);
        priorityModel.getListPriority().observe(getActivity(), new Observer<List<Priority>>() {
            @Override
            public void onChanged(List<Priority> priorities) {
                if(priorities.size()>0){
                    priorityAdapter.setData(priorities);
                    rcv_Priority.setAdapter(priorityAdapter);
                }
            }
        });
        //init UI
        btnNewPriority = (FloatingActionButton) root.findViewById(R.id.btnNewPriority);
        btnNewPriority.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Add_dialog_priority add = new Add_dialog_priority();
                add.show(getActivity().getSupportFragmentManager(),"add");
            }
        });
        return root;
    }

    public void updateClicked(Priority priority) {
        EditPriority edit = new EditPriority(priority);
        edit.show(getActivity().getSupportFragmentManager(),"edit");
    }

    @Override
    public void deleteClicked(Priority priority) {
        priorityModel.deletePriority(priority);
    }
}