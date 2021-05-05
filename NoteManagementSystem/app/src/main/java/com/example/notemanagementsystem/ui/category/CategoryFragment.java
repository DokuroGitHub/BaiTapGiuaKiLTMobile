package com.example.notemanagementsystem.ui.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notemanagementsystem.Adapter.CategoryAdapter;
import com.example.notemanagementsystem.DashboardActivity;
import com.example.notemanagementsystem.Model.Category;
import com.example.notemanagementsystem.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class CategoryFragment extends Fragment implements CategoryAdapter.ClickListener {

    private CategoryModel categoryModel;
    private RecyclerView rcv_Category;
    private CategoryAdapter categoryAdapter;
    private List<Category> mListCategory;
    private FloatingActionButton btnNewCategory;
    static int userID;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //take userID
        getDataFromDB();
        View root = inflater.inflate(R.layout.fragment_category, container, false);
        categoryAdapter = new CategoryAdapter(this);
        rcv_Category = root.findViewById(R.id.rcv_category);
        rcv_Category.setLayoutManager(new LinearLayoutManager(root.getContext()));
        categoryModel = new ViewModelProvider(this).get(CategoryModel.class);
        categoryModel.getListCategory(userID).observe(getActivity(), new Observer<List<Category>>() {
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
                Add_dialog_category add = new Add_dialog_category(userID);
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

    public void getDataFromDB(){
        DashboardActivity activity = (DashboardActivity)getActivity();
        Bundle results = activity.getMyData();
        userID = results.getInt("userID");
    }
}