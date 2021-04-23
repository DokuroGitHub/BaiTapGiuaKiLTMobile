package com.example.notemanagementsystem.ui.note;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notemanagementsystem.Adapter.CategoryAdapter;
import com.example.notemanagementsystem.Data.CategoryDAO;
import com.example.notemanagementsystem.Data.NoteDAO;
import com.example.notemanagementsystem.Data.NoteManagementDatabase;
import com.example.notemanagementsystem.Model.Category;
import com.example.notemanagementsystem.Model.Note;
import com.example.notemanagementsystem.Model.Priority;
import com.example.notemanagementsystem.Model.Status;
import com.example.notemanagementsystem.R;
import com.example.notemanagementsystem.ui.category.CategoryModel;
import com.example.notemanagementsystem.ui.priority.PriorityModel;
import com.example.notemanagementsystem.ui.status.StatusViewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class EditNote extends AppCompatDialogFragment  {
    private Category category;
    private Priority priority;
    private Status status;
    public Spinner spinner;
    public Spinner spinner1;
    public Spinner spinner2;
    private NoteDAO noteDAO;
    private NoteViewModel noteViewModel;
    static int categoryID = 0;
    static int priorityID = 0;
    static int statusID = 0;
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.add_note_dialog,null);
        //init

        /**Add new status
         * use spinner
         * use dateTimePicker dialog
         */
        //Show plane date
        TextView txt_planDate = view.findViewById(R.id.txt_planDate);
        Button btn_planDate = view.findViewById(R.id.btn_planDate);
        btn_planDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog(txt_planDate);
            }
        });
        /**Spinner for
         * Category
         * Priority
         * Status
         * take id from name
         */
        //Category
        spinner = view.findViewById(R.id.sp_category);
        categorySpinner();
        //Priority
        spinner1 = view.findViewById(R.id.sp_priority);
        prioritySpinner();
        //Status
        spinner2 = view.findViewById(R.id.sp_status);
        statusSpinner();
        //Add status
        EditText edt_noteName = view.findViewById(R.id.edt_noteName);
        Button btn_addStatus = view.findViewById(R.id.btn_addNote);
        btn_addStatus.setText("Update");
        btn_addStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noteName = edt_noteName.getText().toString().trim();
                int categoryName = categoryID;
                int priorityName = priorityID;
                int statusName = statusID;
                String planDate = txt_planDate.getText().toString().trim();
                //date
                SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date now = new Date();
                String strCreateDate = sdfDate.format(now);
                if(TextUtils.isEmpty(noteName)){
                    return;
                }
                noteDAO = NoteManagementDatabase.getInstance(v.getContext()).getNoteDAO();
                Note note  = new Note(noteName,categoryName,priorityName,statusName,planDate,strCreateDate);
                noteViewModel = new ViewModelProvider(getActivity()).get(NoteViewModel.class);
                noteViewModel.insertNote(note);
                Toast.makeText(v.getContext(),"Create note successfully",Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });

        //close
        Button btn_closeStatus = view.findViewById(R.id.btn_closeNote);
        btn_closeStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        builder.setView(view);
        return builder.create();

    }

    private void showDateDialog(final TextView txt)
    {
        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(" d/M/yyyy");
                txt.setText(simpleDateFormat.format(calendar.getTime()));

            }
        };
        new DatePickerDialog(getActivity(),dateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void categorySpinner(){
        CategoryModel categoryModel = new ViewModelProvider(this).get(CategoryModel.class);
        List<Category> categories = new ArrayList<>();
        categories = categoryModel.getListCategories();
        final ArrayAdapter arrayAdapter = new ArrayAdapter<>(getContext(),R.layout.support_simple_spinner_dropdown_item,categories);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Category category= (Category) spinner.getSelectedItem();
                categoryID = category.getId();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void prioritySpinner(){
        PriorityModel priorityModel = new ViewModelProvider(this).get(PriorityModel.class);
        List<Priority> priorities = new ArrayList<>();
        priorities = priorityModel.getListPriorityDF();
        final ArrayAdapter arrayAdapter = new ArrayAdapter<>(getContext(),R.layout.support_simple_spinner_dropdown_item,priorities);
        spinner1.setAdapter(arrayAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Priority priority= (Priority) spinner1.getSelectedItem();
                priorityID = priority.getId();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void statusSpinner(){
        StatusViewModel statusViewModel = new ViewModelProvider(this).get(StatusViewModel.class);
        List<Status> mListStatus = new ArrayList<>();
        mListStatus = statusViewModel.getListStatusDF();
        final ArrayAdapter arrayAdapter = new ArrayAdapter<>(getContext(),R.layout.support_simple_spinner_dropdown_item,mListStatus);
        spinner2.setAdapter(arrayAdapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Status status= (Status) spinner2.getSelectedItem();
                statusID = status.getId();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }




}