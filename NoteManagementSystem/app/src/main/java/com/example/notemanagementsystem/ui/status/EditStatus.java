package com.example.notemanagementsystem.ui.status;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notemanagementsystem.Adapter.StatusAdapter;
import com.example.notemanagementsystem.Data.NoteManagementDatabase;
import com.example.notemanagementsystem.Data.StatusDAO;
import com.example.notemanagementsystem.Model.Status;
import com.example.notemanagementsystem.R;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EditStatus extends AppCompatDialogFragment {
    private EditText edt_statusName;
    private StatusAdapter statusAdapter;
    private List<Status> mListStatus;
    private StatusDAO statusDAO;
    private Status status;
    private RecyclerView rcv_Status;
    private StatusViewModel statusModel;

    public EditStatus(Status status) {
        this.status = status;
    }

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.edit_status_dialog,null);
        //init
        edt_statusName = view.findViewById(R.id.edt_updateStatusName);
        rcv_Status = (RecyclerView)view.findViewById(R.id.rcv_status);
        //update
        Button btn_editStatus = view.findViewById(R.id.btn_editStatus);
        btn_editStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strStatusName = edt_statusName.getText().toString().trim();
                //date
                SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date now = new Date();
                String strCreateDate = sdfDate.format(now);
                if(TextUtils.isEmpty(strStatusName)){
                    return;
                }
                statusDAO = NoteManagementDatabase.getInstance(v.getContext()).getStatusDAO();
                statusModel = new ViewModelProvider(getActivity()).get(StatusViewModel.class);
                status.setStatusName(strStatusName);
                StatusViewModel.updateStatus(status);
                Toast.makeText(v.getContext(),"Update status successfully",Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });

        //close
        Button btn_closeStatus = view.findViewById(R.id.btn_closeStatus);
        btn_closeStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        builder.setView(view);
        return builder.create();

    }
}