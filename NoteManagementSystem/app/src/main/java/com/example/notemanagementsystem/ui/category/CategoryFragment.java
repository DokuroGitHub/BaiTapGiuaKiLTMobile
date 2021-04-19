package com.example.notemanagementsystem.ui.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.notemanagementsystem.R;

public class CategoryFragment extends Fragment {

    private CategoryModel categoryModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        categoryModel =
                new ViewModelProvider(this).get(CategoryModel.class);
        View root = inflater.inflate(R.layout.fragment_category, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        categoryModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}