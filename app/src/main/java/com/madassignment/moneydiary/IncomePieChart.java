package com.madassignment.moneydiary;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IncomePieChart#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IncomePieChart extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public IncomePieChart() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IncomePieChart.
     */
    // TODO: Rename and change types and number of parameters
    public static IncomePieChart newInstance(String param1, String param2) {
        IncomePieChart fragment = new IncomePieChart();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        PieChart income = getView().findViewById(R.id.incomePie);

        ArrayList<PieEntry> visitors = new ArrayList<>();
        visitors.add(new PieEntry(5000, "First Income Source"));
        visitors.add(new PieEntry(2000, "Second Income Source"));
        visitors.add(new PieEntry(300, "Investment"));
        visitors.add(new PieEntry(900, "Property Rent Income"));

        PieDataSet pieDataSet = new PieDataSet(visitors,"January 2021 Income");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);

        PieData pieData = new PieData(pieDataSet);

        income.setData(pieData);
        income.getDescription().setEnabled(false);
        income.setCenterText("January 2021 Income");
        income.animate();

        return inflater.inflate(R.layout.fragment_income_pie_chart, container, false);
    }
}