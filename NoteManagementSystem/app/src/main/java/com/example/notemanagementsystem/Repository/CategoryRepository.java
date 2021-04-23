package com.example.notemanagementsystem.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.notemanagementsystem.Data.CategoryDAO;
import com.example.notemanagementsystem.Data.NoteManagementDatabase;
import com.example.notemanagementsystem.Model.Category;
import com.example.notemanagementsystem.Model.NoteAndMenu;

import java.util.List;

public class CategoryRepository {
    private CategoryDAO categoryDAO;
    NoteManagementDatabase db;
    private LiveData<List<Category>> mListCategory;

    public CategoryRepository(Application application) {
        db = NoteManagementDatabase.getInstance(application);
        categoryDAO = db.getCategoryDAO();
        mListCategory = categoryDAO.getListCategory();
    }

    public LiveData<List<Category>> getListCategory(){
        return categoryDAO.getListCategory();
    }

    public List<Category> getListCategories(){return categoryDAO.getListCategories();}
    public void insertCategory(final Category category) {
        NoteManagementDatabase.databaseWriteExecutor.execute(() -> {
            categoryDAO.insert(category);
        });
    }

    public void updateCategory(final Category category) {
        NoteManagementDatabase.databaseWriteExecutor.execute(() -> {
            categoryDAO.update(category);
        });
    }

    public void deleteCategory(final Category category) {
        NoteManagementDatabase.databaseWriteExecutor.execute(() -> {
            categoryDAO.delete(category);
        });
    }
}