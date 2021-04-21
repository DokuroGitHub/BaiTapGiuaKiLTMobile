package com.example.notemanagementsystem.ui.category;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import com.example.notemanagementsystem.Data.CategoryDAO;
import com.example.notemanagementsystem.Data.NoteManagementDatabase;
import com.example.notemanagementsystem.Model.Category;
import com.example.notemanagementsystem.R;
import com.example.notemanagementsystem.ui.home.HomeViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {
    private static final int MY_REQUEST_CODE = 10;
    private CategoryModel categoryModel;
    private CategoryDAO categoryDAO;
    private RecyclerView rcv_Category;
    private CategoryAdapter categoryAdapter;
    private List<Category> mListCategory;
    private FloatingActionButton btnNewCategory;
    private Category category;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_category, container, false);
        categoryAdapter = new CategoryAdapter(root.getContext());
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
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case 101:
                return true;
            case 102:
                return false;
        }
        return super.onContextItemSelected(item);
    }
}