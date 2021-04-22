package com.example.notemanagementsystem.ui.priority;

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

import com.example.notemanagementsystem.Data.NoteManagementDatabase;
import com.example.notemanagementsystem.Model.Priority;
import com.example.notemanagementsystem.R;

import com.example.notemanagementsystem.Data.PriorityDAO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateP_dialog extends AppCompatDialogFragment {
    private EditText edt_updatePriorityName;
    private RecyclerView rcv_Priority;
    private PriorityDAO priorityDAO;
    private PriorityModel priorityModel;
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.edit_priority_dialog,null);
        //init
        edt_updatePriorityName = view.findViewById(R.id.edt_updatePriorityName);
        rcv_Priority = (RecyclerView)view.findViewById(R.id.rcv_priority);

        Button btn_editPriority = view.findViewById(R.id.btn_editPriority);
        btn_editPriority.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strPriorityName = edt_updatePriorityName.getText().toString().trim();
                //date
                SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date now = new Date();
                String strCreateDate = sdfDate.format(now);
                if(TextUtils.isEmpty(strPriorityName)){
                    return;
                }
                //update
                priorityDAO = NoteManagementDatabase.getInstance(v.getContext()).getPriorityDAO();
                Priority priority = new Priority(strPriorityName,strCreateDate);
                priorityModel = new ViewModelProvider(getActivity()).get(PriorityModel.class);
                priorityModel.updatePriority(priority);
                Toast.makeText(v.getContext(),"Update priority successfully",Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
        Button btn_closePriority = view.findViewById(R.id.btn_closePriority);
        btn_closePriority.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        builder.setView(view);
        return builder.create();
    }

}
