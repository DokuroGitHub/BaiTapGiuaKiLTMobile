package com.example.notemanagementsystem.ui.priority;

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

public class PriorityFragment extends Fragment {

    private PriorityModel priorityModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        priorityModel =
                new ViewModelProvider(this).get(PriorityModel.class);
        View root = inflater.inflate(R.layout.fragment_priority, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        priorityModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}