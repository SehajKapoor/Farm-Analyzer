package com.example.getcurrentlocation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class WeatherBarGraph extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
ImageView imageGraph;
Spinner spinGraph;
    String[] title = { "Weather Graph Analysis","", "Sensor Graph Analysis","","Weather Vs Sensor Analysis" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_bar_graph);
        imageGraph=findViewById(R.id.imageGraph);
        spinGraph=findViewById(R.id.spin);

        spinGraph.setOnItemSelectedListener(this);
        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                title);

        spinGraph.setAdapter(ad);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (title[position]=="Weather Graph Analysis"){
            imageGraph.setImageResource(R.drawable.weathergraph);
        }
        else if (title[position]=="Sensor Graph Analysis"){
            imageGraph.setImageResource(R.drawable.sensorgraph);
        }
        else if (title[position]=="Weather Vs Sensor Analysis"){
            imageGraph.setImageResource(R.drawable.erroranalysis);
        }
        else{
            Toast.makeText(WeatherBarGraph.this, "Something went wrong.Try Again!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}