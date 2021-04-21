package com.example.notemanagementsystem.ui.category;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notemanagementsystem.Data.CategoryDAO;
import com.example.notemanagementsystem.Data.NoteManagementDatabase;
import com.example.notemanagementsystem.Model.Category;
import com.example.notemanagementsystem.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Update_dialog extends AppCompatDialogFragment {
    private EditText edt_updateCategoryName;
    private RecyclerView rcv_Category;
    private CategoryDAO categoryDAO;
    private CategoryModel categoryModel;
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.edit_category_dialog,null);
        //init
        edt_updateCategoryName = view.findViewById(R.id.edt_updateCategoryName);
        rcv_Category = (RecyclerView)view.findViewById(R.id.rcv_category);
        //set text when update
        
        //update
        Button btn_editCategory = view.findViewById(R.id.btn_editCategory);
        btn_editCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strCategoryName = edt_updateCategoryName.getText().toString().trim();
                //date
                SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date now = new Date();
                String strCreateDate = sdfDate.format(now);
                if(TextUtils.isEmpty(strCategoryName)){
                    return;
                }
                //update
                categoryDAO = NoteManagementDatabase.getInstance(v.getContext()).getCategoryDAO();
                Category category = new Category(strCategoryName,strCreateDate);
                categoryModel = new ViewModelProvider(getActivity()).get(CategoryModel.class);
                categoryModel.updateCategory(category);
                Toast.makeText(v.getContext(),"Update category successfully",Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
        Button btn_closeCategory = view.findViewById(R.id.btn_closeCategory);
        btn_closeCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        builder.setView(view);
        return builder.create();
    }
}
