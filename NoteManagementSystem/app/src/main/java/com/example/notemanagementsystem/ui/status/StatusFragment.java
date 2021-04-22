package com.example.notemanagementsystem.ui.status;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notemanagementsystem.Adapter.CategoryAdapter;
import com.example.notemanagementsystem.Adapter.StatusAdapter;
import com.example.notemanagementsystem.Data.NoteManagementDatabase;
import com.example.notemanagementsystem.Model.Category;
import com.example.notemanagementsystem.Model.Status;
import com.example.notemanagementsystem.R;
import com.example.notemanagementsystem.ui.category.CategoryModel;
import com.example.notemanagementsystem.ui.home.HomeViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class StatusFragment extends Fragment {

    private StatusViewModel statusModel;
    private RecyclerView rcv_Status;
    private StatusAdapter statusAdapter;
    private List<Category> mListStatus;
    private FloatingActionButton btnNewStatus;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_status, container, false);
        statusAdapter = new StatusAdapter();
        rcv_Status = root.findViewById(R.id.rcv_status);
        rcv_Status.setLayoutManager(new LinearLayoutManager(root.getContext()));
        statusModel = new ViewModelProvider(this).get(StatusViewModel.class);
        statusModel.getListStatus().observe(getActivity(), new Observer<List<Status>>() {
            @Override
            public void onChanged(List<Status> statuses) {
                if(statuses.size()>0){
                    statusAdapter.setData(statuses);
                    rcv_Status.setAdapter(statusAdapter);
                }
            }
        });
        //init UI
        btnNewStatus = (FloatingActionButton) root.findViewById(R.id.btnNewStatus);
        btnNewStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Add_dialog add = new Add_dialog();
                add.show(getActivity().getSupportFragmentManager(),"add");
            }
        });
        return root;
    }

}