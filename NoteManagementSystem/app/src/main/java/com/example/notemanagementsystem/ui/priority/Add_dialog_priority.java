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

import com.example.notemanagementsystem.Adapter.PriorityAdapter;
import com.example.notemanagementsystem.Data.NoteManagementDatabase;
import com.example.notemanagementsystem.Data.PriorityDAO;
import com.example.notemanagementsystem.Model.Category;
import com.example.notemanagementsystem.Model.Priority;
import com.example.notemanagementsystem.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Add_dialog_priority extends AppCompatDialogFragment {
    private EditText edt_priorityName;
    private PriorityAdapter priorityAdapter;
    private List<Priority> mPriorityList;
    private PriorityDAO priorityDAO;
    private RecyclerView rcv_Priority;
    private PriorityModel priorityModel;
    static int userID;

    public Add_dialog_priority(int userID){
        this.userID = userID;
    }
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_priority_dialog,null);
        //init
        edt_priorityName = view.findViewById(R.id.edt_PriorityName);
        rcv_Priority = (RecyclerView)view.findViewById(R.id.rcv_priority);

        //add
        Button btn_addPriority = view.findViewById(R.id.btn_addPriority);
        btn_addPriority.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strPriorityName = edt_priorityName.getText().toString().trim();
                //date
                SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date now = new Date();
                String strCreateDate = sdfDate.format(now);
                if(TextUtils.isEmpty(strPriorityName)){
                    return;
                }
                if(isPriorityExist(strPriorityName,userID)){
                    Toast.makeText(v.getContext(),strPriorityName +" already exist",Toast.LENGTH_SHORT).show();
                }
                else {
                    priorityDAO = NoteManagementDatabase.getInstance(v.getContext()).getPriorityDAO();
                    Priority priority = new Priority(strPriorityName,strCreateDate,userID);
                    priorityModel = new ViewModelProvider(getActivity()).get(PriorityModel.class);
                    priorityModel.insertPriority(priority);
                    Toast.makeText(v.getContext(),"Create priority successfully",Toast.LENGTH_SHORT).show();
                    dismiss();
                }
            }
        });

        //close
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

    private boolean isPriorityExist(String priorityName,int userID){
        List<Priority> priorities = NoteManagementDatabase.getInstance(getActivity()).getPriorityDAO().checkPriority(priorityName,userID);
        return priorities != null && !priorities.isEmpty();
    }
}
