package com.example.notemanagementsystem.ui.status;

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

import com.example.notemanagementsystem.Adapter.StatusAdapter;
import com.example.notemanagementsystem.Model.Status;
import com.example.notemanagementsystem.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class StatusFragment extends Fragment implements StatusAdapter.ClickListener{

    private StatusViewModel statusModel;
    private RecyclerView rcv_Status;
    private StatusAdapter statusAdapter;
    private List<Status> mListStatus;
    private FloatingActionButton btnNewStatus;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_status, container, false);
        statusAdapter = new StatusAdapter(this);
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
                Add_dialog_status add = new Add_dialog_status();
                add.show(getActivity().getSupportFragmentManager(),"add");
            }
        });
        return root;
    }

    @Override
    public void updateClicked(Status status) {
        EditStatus edit = new EditStatus(status);
        edit.show(getActivity().getSupportFragmentManager(),"edit");
    }

    @Override
    public void deleteClicked(Status status) {
        statusModel.deleteStatus(status);
    }
}