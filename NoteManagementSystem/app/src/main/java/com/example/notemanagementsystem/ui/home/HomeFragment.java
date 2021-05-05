package com.example.notemanagementsystem.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.example.notemanagementsystem.DashboardActivity;
import com.example.notemanagementsystem.Data.CategoryDAO;
import com.example.notemanagementsystem.Data.NoteDAO;
import com.example.notemanagementsystem.Data.NoteManagementDatabase;
import com.example.notemanagementsystem.R;
import com.google.android.material.transition.Hold;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private AnyChartView anyChartView;
    private NoteDAO noteDAO;
    static int userID;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        getDataFromDB();
        noteDAO = NoteManagementDatabase.getInstance(getContext()).getNoteDAO();
        String [] status = noteDAO.getStatus(userID);
        int[] percent = noteDAO.getPercent(userID);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        anyChartView= root.findViewById(R.id.chart);
        setupPieChart(status,percent);

     return root;
    }

    public void setupPieChart(String [] status,int[] percent) {
        Pie pie = AnyChart.pie();
        List<DataEntry> dataEntries = new ArrayList<>();

        for(int i = 0; i<status.length;i++){
            dataEntries.add(new ValueDataEntry(status[i],percent[i]));
        }
        pie.data(dataEntries);
        anyChartView.setChart(pie);
    }

    public void getDataFromDB(){
        DashboardActivity activity = (DashboardActivity)getActivity();
        Bundle results = activity.getMyData();
        userID = results.getInt("userID");
    }

}