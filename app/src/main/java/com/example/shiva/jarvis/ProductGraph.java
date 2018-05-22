package com.example.shiva.jarvis;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class ProductGraph extends AppCompatActivity {

    PieChart pieChart;
    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_graph);

        pieChart = (PieChart)findViewById(R.id.piechart);
        barChart = (BarChart)findViewById(R.id.barchart);

        List<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(30f, "Data 1"));
        entries.add(new PieEntry(50f, "Data 2"));

        PieDataSet pieDataSet = new PieDataSet(entries, "Label");
        //pieDataSet.setColor(Color.RED);
        pieDataSet.setColors(new int[]{Color.RED, Color.BLUE, Color.GREEN, Color.CYAN, Color.GRAY});
        pieDataSet.setValueTextColor(Color.WHITE);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.invalidate();

        List<BarEntry> barEntries = new ArrayList<>();

        barEntries.add(new BarEntry(20f,40f));

        BarDataSet barDataSet = new BarDataSet(barEntries, "BarChart LAbel");

        BarData barData = new BarData(barDataSet);

        barChart.setData(barData);



    }
}
