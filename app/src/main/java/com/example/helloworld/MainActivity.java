package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;

//public class MainActivity extends AppCompatActivity {
//    // Create an array with options
//    private String [] workStatus = {"Employed", "Unemployed"};
//    Spinner sp;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Get reference to spinner
//        sp = findViewById(R.id.spinner);
//
//        // Create an adapter
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, workStatus);
//        // Connect adapter to spinner
//        sp.setAdapter(dataAdapter);
//    }
//
//}

public class MainActivity extends ListActivity {
    private static final String[] WEEKDAYS = new String[]{
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, WEEKDAYS));
        ListView lv = getListView();
        lv.setTextFilterEnabled(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long ig) {
                Toast.makeText(getApplicationContext(),
                        ((TextView)view).getText(), Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}

