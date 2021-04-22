package com.example.notemanagementsystem.ui.category;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
import com.example.notemanagementsystem.Data.NoteManagementDatabase;
import com.example.notemanagementsystem.Model.Category;
import com.example.notemanagementsystem.R;
import com.example.notemanagementsystem.ui.home.HomeViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment implements CategoryAdapter.ClickListener {

    private CategoryModel categoryModel;
    private RecyclerView rcv_Category;
    private CategoryAdapter categoryAdapter;
    private List<Category> mListCategory;
    private FloatingActionButton btnNewCategory;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_category, container, false);

        categoryAdapter = new CategoryAdapter(this);
        rcv_Category = root.findViewById(R.id.rcv_category);
        rcv_Category.setLayoutManager(new LinearLayoutManager(root.getContext()));
        categoryModel = new ViewModelProvider(this).get(CategoryModel.class);
        categoryModel.getListCategory().observe(getActivity(), new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                if(categories.size()>0){
                    categoryAdapter.setData(categories);
                    rcv_Category.setAdapter(categoryAdapter);
                }
            }
        });
        //init UI
        btnNewCategory = (FloatingActionButton) root.findViewById(R.id.btnNewCategory);
        btnNewCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Add_dialog add = new Add_dialog();
                add.show(getActivity().getSupportFragmentManager(),"add");
            }
        });
        return root;
    }

    @Override
    public void updateClicked(Category category) {
        EditCategory edit = new EditCategory(category);
        edit.show(getActivity().getSupportFragmentManager(),"edit");
    }

    @NonNull
    @Override
    public void deleteClicked(Category category) {
        categoryModel.deleteCategory(category);
    }
}