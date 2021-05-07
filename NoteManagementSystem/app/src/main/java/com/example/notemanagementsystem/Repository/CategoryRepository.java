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
    private int userID;

    public CategoryRepository(Application application) {
        db = NoteManagementDatabase.getInstance(application);
        categoryDAO = db.getCategoryDAO();
        mListCategory = categoryDAO.getListCategory(userID);
    }

    public LiveData<List<Category>> getListCategory(final int userID){
        return categoryDAO.getListCategory(userID);
    }

    public List<Category> getListCategories(final int userID){return categoryDAO.getListCategories(userID);}
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