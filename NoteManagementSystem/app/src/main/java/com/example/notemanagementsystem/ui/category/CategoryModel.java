package com.example.notemanagementsystem.ui.category;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.notemanagementsystem.Model.Category;
import com.example.notemanagementsystem.Model.NoteAndMenu;
import com.example.notemanagementsystem.Repository.CategoryRepository;

import java.util.List;

public class CategoryModel extends AndroidViewModel {
    private CategoryRepository categoryRepository;
    LiveData<List<Category>> mListCategory;
    private int userID;

    public CategoryModel(@NonNull Application application){
        super(application);
        categoryRepository = new CategoryRepository(application);
        mListCategory = categoryRepository.getListCategory(userID);
    }

    public LiveData<List<Category>> getListCategory(final int userID){
        return categoryRepository.getListCategory(userID);
    }

    public List<Category> getListCategories(final int userID){
        return categoryRepository.getListCategories(userID);
    }
    public void insertCategory(Category category){
        categoryRepository.insertCategory(category);
    }
    public void updateCategory(Category category){
        categoryRepository.updateCategory(category);
    }
    public void deleteCategory(Category category) {
        categoryRepository.deleteCategory(category);
    }


}