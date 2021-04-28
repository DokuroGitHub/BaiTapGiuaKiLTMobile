package com.example.notemanagementsystem.ui.category;

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

import com.example.notemanagementsystem.Adapter.CategoryAdapter;
import com.example.notemanagementsystem.Data.CategoryDAO;
import com.example.notemanagementsystem.Data.NoteManagementDatabase;
import com.example.notemanagementsystem.Model.Category;
import com.example.notemanagementsystem.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Add_dialog_category extends AppCompatDialogFragment {
    private EditText edt_categoryName;
    private CategoryAdapter categoryAdapter;
    private List<Category> mListCategory;
    private CategoryDAO categoryDAO;
    private RecyclerView rcv_Category;
    private CategoryModel categoryModel;
    static int userID;

    public Add_dialog_category(int userID){
        this.userID = userID;
    }

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.add_category_dialog,null);
        //init
        edt_categoryName = view.findViewById(R.id.edt_categoryName);
        rcv_Category = (RecyclerView)view.findViewById(R.id.rcv_category);
        //add
        Button btn_addCategory = view.findViewById(R.id.btn_addCategory);
        btn_addCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strCategoryName = edt_categoryName.getText().toString().trim();
                //date
                SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date now = new Date();
                String strCreateDate = sdfDate.format(now);
                if(TextUtils.isEmpty(strCategoryName)){
                    return;
                }
                //insert
                categoryDAO = NoteManagementDatabase.getInstance(v.getContext()).getCategoryDAO();
                Category category = new Category(strCategoryName,strCreateDate,userID);
                categoryModel = new ViewModelProvider(getActivity()).get(CategoryModel.class);
                categoryModel.insertCategory(category);
                Toast.makeText(v.getContext(),"Create category successfully",Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
        //close
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