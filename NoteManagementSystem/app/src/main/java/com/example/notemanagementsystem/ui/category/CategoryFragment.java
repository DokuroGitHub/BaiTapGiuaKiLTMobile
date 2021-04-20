package com.example.notemanagementsystem.ui.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notemanagementsystem.Adapter.CategoryAdapter;
import com.example.notemanagementsystem.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CategoryFragment extends Fragment {

    private CategoryModel categoryModel;
    private RecyclerView rcv_Category;
    private CategoryAdapter categoryAdapter;
    private FloatingActionButton btnNewCategory;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        categoryModel =
                new ViewModelProvider(this).get(CategoryModel.class);
        View root = inflater.inflate(R.layout.fragment_category, container, false);
        //init UI
        rcv_Category = (RecyclerView) root.findViewById(R.id.rcv_category);
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

}