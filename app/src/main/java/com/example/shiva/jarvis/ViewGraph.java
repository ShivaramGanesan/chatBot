package com.example.shiva.jarvis;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class ViewGraph extends AppCompatActivity {

    LineChart linechart;
    LineData lineData;
    LineDataSet lineDataSet;
    LineDataSet newLineDataSet;
    LineDataSet reachDataSet;
    LineData l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_graph);

        linechart = (LineChart)findViewById(R.id.linechart);
        CardView  importG = (CardView)findViewById(R.id.importgraph);
        CardView  valuesG = (CardView)findViewById(R.id.valuesGraph);
        CardView  reachG = (CardView)findViewById(R.id.reachGraph);


        List<Entry> entries = new ArrayList<>();

        entries.add(new Entry(5f,50.3f));
        entries.add(new Entry(48f,56.8f));
        entries.add(new Entry(100f,20.5f));


        lineDataSet = new LineDataSet(entries,"Import");

        lineDataSet.setColor(Color.BLUE);
        lineDataSet.setValueTextColor(Color.WHITE);
        lineDataSet.setDrawCircleHole(true);
        lineDataSet.disableDashedLine();
        lineDataSet.setCircleRadius(5f);
        lineDataSet.setFillColor(Color.BLUE);
        lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);

        //lineData = new LineData(lineDataSet);

        List<Entry> entries1 = new ArrayList<>();
        entries1.add(new Entry(5f,50.3f));
        entries1.add(new Entry(48f,56.8f));
        entries1.add(new Entry(100f,20.5f));

        newLineDataSet = new LineDataSet(entries1,"Values");
        //newLineDataSet.setColor(Color.RED);
        newLineDataSet.setColors(new int[]{Color.RED, Color.BLUE, Color.GREEN});
        newLineDataSet.setValueTextColor(Color.WHITE);
        newLineDataSet.setDrawCircleHole(true);
        newLineDataSet.disableDashedLine();
        newLineDataSet.setCircleRadius(5f);
        newLineDataSet.setFillColor(Color.RED);
        newLineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);

        List<Entry> entries2 = new ArrayList<>();
        entries2.add(new Entry(5f,50.3f));
        entries2.add(new Entry(48f,56.8f));
        entries2.add(new Entry(100f,20.5f));


        reachDataSet = new LineDataSet(entries2,"Reach");
        //reachDataSet.setColor(Color.BLACK);
        reachDataSet.setColors(new int[]{Color.RED, Color.BLUE, Color.GREEN});
        reachDataSet.setValueTextColor(Color.WHITE);
        reachDataSet.setDrawCircleHole(true);
        reachDataSet.disableDashedLine();
        reachDataSet.setCircleRadius(5f);
        reachDataSet.setFillColor(Color.BLACK);
        reachDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);


        // LineData lineData1 = new LineData(newLineDataSet);
        linechart.setData(lineData);
        //linechart.setData(lineData1);
        Toast.makeText(this, "lineData", Toast.LENGTH_SHORT).show();
        linechart.setDrawGridBackground(false);
        linechart.getAxisLeft().setDrawGridLines(false);
        linechart.getAxisRight().setDrawGridLines(false);
        linechart.getAxisRight().setDrawAxisLine(false);
        linechart.getAxisLeft().setDrawAxisLine(false);


        linechart.invalidate();


        importG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 l = new LineData(lineDataSet);
                linechart.setData(l);
                //linechart.setData(lineData1);

                linechart.setDrawGridBackground(false);
                linechart.getAxisLeft().setDrawGridLines(false);
                linechart.getAxisRight().setDrawGridLines(false);
                linechart.getAxisRight().setDrawAxisLine(false);
                linechart.getAxisLeft().setDrawAxisLine(false);


                linechart.invalidate();
                //Toast.makeText(ViewGraph.this, "Hello", Toast.LENGTH_SHORT).show();

            }
        });


        valuesG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 l = new LineData(newLineDataSet);

                linechart.setData(l);

                linechart.setDrawGridBackground(false);
                linechart.getAxisLeft().setDrawGridLines(false);
                linechart.getAxisRight().setDrawGridLines(false);
                linechart.getAxisRight().setDrawAxisLine(false);
                linechart.getAxisLeft().setDrawAxisLine(false);


                linechart.invalidate();
            }
        });

        reachG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LineData l = new LineData(reachDataSet);

                linechart.setData(l);

                linechart.setDrawGridBackground(false);
                linechart.getAxisLeft().setDrawGridLines(false);
                linechart.getAxisRight().setDrawGridLines(false);
                linechart.getAxisRight().setDrawAxisLine(false);
                linechart.getAxisLeft().setDrawAxisLine(false);


                linechart.invalidate();

            }
        });







    }
}
